extends CanvasLayer

var time_since_last_shot = 0.0
var fire_rate = 1.0
var can_shoot = true

var weapon_texture = {
	"handgun": preload("res://assets/hudgun.png"),
	"rifle": preload("res://assets/hudmachinegun.png"),
	"mini": preload("res://assets/hudmini.png"),
	"knife": preload("res://assets/hudknife.png"),
}

func _ready():
	$Weapon.play(Global.current_weapon + "_idle")
	await $Weapon.animation_finished.connect(_on_AnimationSprite2D_animation_finished)
	$James.play("100")
	update_weapon_icon()
	
	if $ColorRect.color != Global.theme_color:
		$ColorRect.color = Global.theme_color

func _process(delta):
	if $ColorRect.color != Global.theme_color:
		$ColorRect.color = Global.theme_color
		
	time_since_last_shot += delta
	can_shoot = time_since_last_shot >= (1 / fire_rate)
	
	if Global.current_weapon != "knife" and Global.ammo <= -1:
		Global.current_weapon = "knife"
		$Weapon.play("knife_idle")
		Global.ammo = 0
	
	if Input.is_action_just_pressed("attack") and can_shoot:

		if Global.current_weapon == "knife":
			$Weapon.play("stab")
		else:
			$Weapon.play(Global.current_weapon + "_shoot")
			
		time_since_last_shot = 0.0
		
		if Global.current_weapon != "knife" and Global.ammo>-1:
			Global.ammo -= 1
		
	match Global.current_weapon:
		"handgun":
			fire_rate = 3
		"rifle":
			fire_rate = 5
		"mini":
			fire_rate = 12.0
		"knife":
			fire_rate = 5.0
	
	
	update_player_health()
	update_ammo()
	update_lives()
	update_level()
	update_score()
	update_weapon_icon()
	update_easter_egg()
	update_face_anim(Global.player_health)


func update_easter_egg():
	if Global.score>1000000:
		$EasterEgg.texture = preload("res://assets/easteregg - copia.png")

func _on_AnimationSprite2D_animation_finished():
	$Weapon.play(Global.current_weapon + "_idle")

func update_level():
	$Level.text = str(Global.current_level)

func update_player_health():
	$Health.text = str(Global.player_health)

func update_ammo():
	$Ammo.text = str(Global.ammo)

func update_lives():
	$Lives.text = str(Global.lives)

func update_score():
	$Score.text = str(Global.score)

func update_weapon_icon():
	if $Gun.texture != weapon_texture[Global.current_weapon]:
		$Gun.texture = weapon_texture[Global.current_weapon]
		$Weapon.play(Global.current_weapon + "_idle")

func update_face_anim(health):
	var animation_name = ""
	if health > 90:
		animation_name = "100"
	elif health > 75:
		animation_name = "90"
	elif health > 60:
		animation_name = "75"
	elif health > 45:
		animation_name = "60"
	elif health > 30:
		animation_name = "45"
	elif health > 15:
		animation_name = "30"
	else:
		animation_name = "15"
	
	$James.play(animation_name)
