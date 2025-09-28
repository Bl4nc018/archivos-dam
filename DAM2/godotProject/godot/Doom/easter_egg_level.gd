extends Node3D

func _on_level_changer_body_entered(body):
	if body.is_in_group("player"):
		Global.current_level = 2
		get_tree().change_scene_to_file("res://final_level.tscn")

func _ready(): 
	Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)
	Global.scene = "res://easter_egg_level.tscn"

