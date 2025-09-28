extends Node

var ammo = 0
var current_weapon = "handgun"
var weapon_before = ""
var player_health = 100
var lives = 3
var current_level = 1
var score = 0
var player_max_health = 100

var theme_color = Color("#0000a4")

var enemy_damage = 10

var scene : String = ""

var boss_health = 2000
var boss_phase : String = "phase1"
