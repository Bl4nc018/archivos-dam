extends CharacterBody3D

@onready var ray_cast_3d = $Camera3D/RayCast3D
@onready var ui_script = $UI

const MOUSE_SENS = 0.05

var dead = false
var SPEED = 1

const attack_range = 1

func _ready(): 
	add_to_group("player")
	

func _input(event):
	if dead: return

	if event is InputEventMouseMotion:
		rotation_degrees.y -= event.relative.x * MOUSE_SENS

func _process(_delta):
	if dead:
		return
	
	if Input.is_action_just_pressed("close"):
		get_tree().quit()


func _physics_process(_delta):
	if dead:
		return
	
	var input_dir = Input.get_vector("move_left", "move_right", "move_forward", "move_backwards")
	var direction = (transform.basis * Vector3(input_dir.x, 0, input_dir.y)).normalized()
	
	if Input.is_action_pressed("sprint"):
		SPEED = 3
	else:
		SPEED = 1.5
	
	if direction:
		velocity.x = direction.x * SPEED
		velocity.z = direction.z * SPEED
	else:
		velocity.x = move_toward(velocity.x, 0, SPEED)
		velocity.z = move_toward(velocity.z, 0, SPEED)

	if Input.is_action_just_pressed("attack"):
		if ui_script.can_shoot:
			shoot()
	
	move_and_slide()


func shoot():
	var sound_player = $AudioStreamPlayer 
	match Global.current_weapon:
		"handgun":
			sound_player.stream = preload("res://assets/gun.ogg")
			sound_player.play()
		"rifle":
			sound_player.stream = preload("res://assets/machine.ogg")
			sound_player.play()
		"mini":
			sound_player.stream = preload("res://assets/mini.ogg")
			sound_player.play()
		"knife":
			sound_player.stop()


	if ray_cast_3d.is_colliding() and ray_cast_3d.get_collider().has_method("kill"):
		if Global.ammo>0 and Global.current_weapon != "knife":
			ray_cast_3d.get_collider().kill()
			Global.boss_health -= 100
			Global.weapon_before = Global.current_weapon
			
		elif Global.ammo>=0 and Global.current_weapon == "knife":
			var origin = ray_cast_3d.global_transform.origin
			var collision_point = ray_cast_3d.get_collision_point()
			var distance = origin.distance_to(collision_point)
			
			if distance>attack_range:
				return
			else:
				ray_cast_3d.get_collider().kill()
				Global.boss_health -= 100
				
		elif Global.ammo > 0 and Global.current_weapon == "knife":
			Global.current_weapon = Global.weapon_before
			ray_cast_3d.get_collider().kill()
			Global.boss_health -= 100
	
	
func damage():
	Global.player_health -= Global.enemy_damage
	
	if Global.player_health <= 0:
		if Global.lives <= 1:
			queue_free()
		else:
			Global.lives -= 1
			get_tree().change_scene_to_file("res://world.tscn")
			Global.player_health = Global.player_max_health
			Global.ammo = 10
			Global.current_weapon = "handgun"
			Global.current_level = 1
			Global.score = 0
