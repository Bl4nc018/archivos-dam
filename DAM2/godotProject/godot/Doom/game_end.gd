extends Control

var username = ""

func _ready():
	Input.set_mouse_mode(Input.MOUSE_MODE_VISIBLE)
	Global.scene = "res://final_level.tscn"
	await _on_line_edit_text_submitted
	

func _process(delta):
	if Input.is_action_just_pressed("close") or Input.is_action_just_pressed("exit"):
		get_tree().quit()

func _on_end_game_pressed():
	get_tree().quit()


func send_post_new_score():
	var score = Global.score
	
	if username == null:
		printerr("Will NOT send POST data with score due to invalid username")
		printerr("There might have been an error loading user_data file")
		return

	# Username OK. Let's send the request
	var http_request = HTTPRequest.new()
	add_child(http_request)
	http_request.request_completed.connect(_on_server_has_responded)
	var json = JSON.stringify({"username": username, "score": score})
	var headers = ["Content-Type: application/json", "Client-Secret: abc"] # CLIENT_SECRET should never be public! If leaked, ALL clients should be force-updated to use a new one
	http_request.request("http://127.0.0.1:8000/score", headers, HTTPClient.METHOD_POST, json)
	
	
func _on_server_has_responded(result, response_code, headers, body):
	var response = JSON.parse_string(body.get_string_from_utf8())
	print("Server response:")
	print(response)



func _on_line_edit_text_submitted(new_text):
	username = new_text
	print(username)
	send_post_new_score()
