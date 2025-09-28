extends Area3D



func _on_body_entered(body):
	if body.is_in_group("player"):
		Global.score += 1000000
		queue_free()
