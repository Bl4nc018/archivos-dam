extends Node3D

func _ready(): 
	Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)
	Global.scene = "res://final_level.tscn"
	Global.ammo = Global.ammo

func _on_level_changer_body_entered(body):
	if body.is_in_group("player"):
		get_tree().change_scene_to_file("res://game_end.tscn")
