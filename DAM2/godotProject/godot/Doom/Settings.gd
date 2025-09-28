extends Control


func _on_return_pressed() -> void:
	get_tree().change_scene_to_file(Global.scene)

func _on_difficulty_item_selected(index):
	if index == 0:
		Global.enemy_damage = 3
		Global.player_max_health = 200
		Global.player_health = 200
		Global.ammo = 15
	elif index == 1:
		Global.enemy_damage = 10
		Global.player_max_health = 100
		Global.player_health = 100
		Global.ammo = 10
	elif index == 2:
		Global.enemy_damage = 15
		Global.player_max_health = 90
		Global.player_health = 90
		Global.ammo = 5

func _on_theme_color_changed(color):
	Global.theme_color = color
	print(Global.theme_color)

func _ready():
	if $ColorRect.color != Global.theme_color:
		$ColorRect.color = Global.theme_color
