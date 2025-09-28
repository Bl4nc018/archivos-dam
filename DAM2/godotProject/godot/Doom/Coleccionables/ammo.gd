extends Area3D


func _on_body_entered(body):
	if body.is_in_group("player"):
		Global.ammo += 10
		Global.current_weapon = Global.weapon_before
		queue_free()
