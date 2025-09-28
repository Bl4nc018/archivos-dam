extends CharacterBody3D

@onready var player : CharacterBody3D = get_tree().get_first_node_in_group("player")
@onready var ray = $RayCast3D

const SPEED = 0.6
var dead = false
var is_attacking = false
var attack_range = 4.8

func _ready():
	add_to_group("enemy")
	Global.boss_phase = "phase1"
	Global.boss_health = 2000
	$Encounter.play()

func _physics_process(_delta):
	if dead or is_attacking or player == null:
		return
	
	var dir = 0
	if player:
		dir = (player.global_transform.origin - global_transform.origin).normalized()
		look_at(global_transform.origin + dir, Vector3(0, 1, 0))
	
	velocity = dir * SPEED
	
	$AnimatedSprite3D.play(Global.boss_phase+"idle")
	move_and_slide()
	
	attempt_to_kill_player()
	

func attempt_to_kill_player():
	var dist_to_player = global_position.distance_to(player.global_position)
	if dist_to_player > attack_range:
		return
	else:
		is_attacking = true
		$AnimatedSprite3D.play(Global.boss_phase+"attack")
		
		var menos_x = randf_range(-30, -20)
		var mas_x = randf_range(20, 30)
		var x = randf_range(menos_x, mas_x)
		
		if is_attacking: 
			velocity = (Vector3(x,0,x))
			move_and_slide()
		
		if ray.is_colliding() and ray.get_collider().has_method("damage"):
			ray.get_collider().damage()
		
		await $AnimatedSprite3D.animation_finished
		is_attacking = false


func kill():
	if Global.boss_phase == "phase2" and Global.boss_health == 0:
		dead = true
		Global.score += 20000
		$AnimatedSprite3D.play(Global.boss_phase+"death")
		$DieFinal.play()
		$CollisionShape3D.disabled = true
	elif Global.boss_phase == "phase1" and Global.boss_health == 0:
		$AnimatedSprite3D.play(Global.boss_phase+"death")
		Global.boss_phase = "phase2"
		$Die1st.play()
		Global.boss_health = 1500

