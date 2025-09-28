extends Node3D

@onready var E1 = $Enemies/Guard


func _ready(): 
	Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)
	Global.scene = "res://level_2.tscn"
	

func _on_level_changer_body_entered(body):
	if body.is_in_group("player"):
		Global.current_level = 3
		Global.score += 1000
		Global.ammo = Global.ammo
		get_tree().change_scene_to_file("res://final_level.tscn")


func _on_level_change_2r_2_body_entered(body):
	if body.is_in_group("player"):
		Global.current_level = "?"
		Global.ammo = Global.ammo
		get_tree().change_scene_to_file("res://easter_egg_level.tscn")
