extends Node3D

func _ready(): 
	Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)
	Global.scene = "res://world.tscn"

func _on_area_3d_body_entered(body):
	if body.is_in_group("player"):
		Global.current_level = 2
		Global.score += 1000
		Global.ammo = Global.ammo
		get_tree().change_scene_to_file("res://level_2.tscn")

