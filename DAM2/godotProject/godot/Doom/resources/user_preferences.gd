class_name UserPreferences extends Resource

@export var difficulty: int = 0
@export var theme: Color = "#ffffff"

@export var enemy_damage: int = 0
@export var player_max_health: int = 0
@export var player_health: int = 0
@export var ammo = 0


func save() -> void:
	ResourceSaver.save(self, "res://resources/user_preferences.tres")

static func load_or_create() -> UserPreferences:
	var res: UserPreferences = load("res://resources/user_preferences.tres") as UserPreferences
	if !res:
		res = UserPreferences.new()
	return res
