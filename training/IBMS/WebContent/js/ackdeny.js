
$(document).ready(
			function() {
					if (((sessionStorage.getItem("itmClick1") == "Acknowledge") || (sessionStorage
							.getItem("itmClick1") == "Deny"))
							&& localStorage.getItem("did") == $("#d").val()) {
						$("#acksubmit").prop("disabled", true);
						$("#denysubmit").prop("disabled", true);
					}

					$("[name=process]").on("click", function() {
						sessionStorage.setItem("itmClick1", $(this).val());
						$("#acksubmit").prop("disabled", true);
						$("#denysubmit").prop("disabled", true);
						localStorage.setItem("did", $("#d").val());
					});

				});
function showLayer() {
	setLayerPosition();

	var shadow = document.getElementById("shadow");
	var question = document.getElementById("question");

	shadow.style.display = "block";
	question.style.display = "block";

	shadow = null;
	question = null;
}