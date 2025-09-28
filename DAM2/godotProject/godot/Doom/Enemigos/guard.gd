extends CharacterBody3D

@onready var player : CharacterBody3D = get_tree().get_first_node_in_group("player")
@onready var ray = $RayCast3D

const SPEED = 4
var dead = false
var is_attacking = false
var attack_range = 15

func _ready():
	add_to_group("enemy")

func _physics_process(_delta):
	if dead or is_attacking or player == null:
		return
	
	var dir = 0
	if player:
		dir = (player.global_transform.origin - global_transform.origin).normalized()
		look_at(global_transform.origin + dir, Vector3(0, 1, 0))
	
	velocity = dir * SPEED
	
	move_and_slide()
	attempt_to_kill_player()
	

func attempt_to_kill_player():
	var dist_to_player = global_position.distance_to(player.global_position)
	if dist_to_player > attack_range:
		return
	else:
		is_attacking = true
		$AnimatedSprite3D.play("shoot")
		
		if ray.is_colliding() and ray.get_collider().has_method("damage"):
			ray.get_collider().damage()
		if ray.is_colliding() and !ray.get_collider().has_method("damage"):
			$AnimatedSprite3D.play("default")
			move_and_slide()
		
		await $AnimatedSprite3D.animation_finished
		is_attacking = false


func kill():
	dead = true
	Global.score += 150
	$AnimatedSprite3D.play("die")
	$AudioStreamPlayer3D.play()
	$CollisionShape3D.disabled = true

