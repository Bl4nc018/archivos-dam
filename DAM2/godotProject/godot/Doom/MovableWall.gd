extends MeshInstance3D

var isMoving = false
var movementSpeed = 0.1

func _process(delta):
	if isMoving:
		translate(Vector3(0, 0, -movementSpeed))

func _on_area_3d_body_entered(body):
	if body.is_in_group("player"):
		isMoving = true

func _on_area_3d_body_exited(body):
	if body.is_in_group("player"):
		isMoving = false
