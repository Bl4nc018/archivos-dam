extends Area3D


func _on_body_entered(body):
	if body.is_in_group("player"):
		Global.player_health = min(Global.player_health + 25, Global.player_max_health)
		queue_free()
