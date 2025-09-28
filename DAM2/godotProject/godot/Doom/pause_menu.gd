extends Control

@onready var _difficulty = %Difficulty
@onready var _theme = %Theme

var user_prefs: UserPreferences

var _is_paused:bool = false:
	set(value):
		_is_paused = value
		get_tree().paused = _is_paused
		visible = _is_paused
		$Menu.visible = _is_paused
		Input.mouse_mode = Input.MOUSE_MODE_VISIBLE

func _unhandled_input(event: InputEvent) -> void:
	if event.is_action_pressed("exit"):
		_is_paused = !_is_paused
		if _is_paused==false and Input.mouse_mode == Input.MOUSE_MODE_VISIBLE:
			Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)

func _on_resume_pressed() -> void:
	_is_paused = false
	Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)

func _on_settings_pressed() -> void:
	$Menu.visible = false
	$Settings.visible = true

func _on_quit_pressed() -> void:
	get_tree().quit()

func _on_return_pressed() -> void:
	$Menu.visible = true
	$Settings.visible = false

func _ready():
	
	user_prefs = UserPreferences.load_or_create()
	
	
	if _difficulty:
		_difficulty.selected = user_prefs.difficulty
	if Global.enemy_damage != user_prefs.enemy_damage:
		Global.enemy_damage = user_prefs.enemy_damage
	if Global.player_max_health != user_prefs.player_max_health:
		Global.player_max_health = user_prefs.player_max_health
	if Global.player_health != user_prefs.player_health:
		Global.player_health = user_prefs.player_health
	if Global.ammo != user_prefs.ammo:
		Global.ammo = user_prefs.ammo
	if _theme:
		_theme.color = user_prefs.theme
		Global.theme_color = user_prefs.theme
	
	if $Menu/ColorRect.color != user_prefs.theme:
		$Menu/ColorRect.color = user_prefs.theme
	if $Settings/ColorRect.color != user_prefs.theme:
		$Settings/ColorRect.color = user_prefs.theme


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
	
	if user_prefs:
		user_prefs.difficulty = index
		user_prefs.enemy_damage = Global.enemy_damage
		user_prefs.player_max_health = Global.player_max_health
		user_prefs.player_health = Global.player_health
		user_prefs.ammo = Global.ammo
		user_prefs.save()

func _on_theme_color_changed(color):
	Global.theme_color = color
	$Menu/ColorRect.color = Global.theme_color
	$Settings/ColorRect.color = Global.theme_color
	
	if user_prefs:
		user_prefs.theme = color
		user_prefs.save()
