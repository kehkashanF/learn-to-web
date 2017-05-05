$(document).ready(
				function() {
					if (((sessionStorage.getItem("itmClick1") == "Available") || (sessionStorage
							.getItem("itmClick1") == "Not Available"))
							&& localStorage.getItem("did") == $("#d").val()) {
						$("#avail").prop("disabled", true);
						$("#navail").prop("disabled", true);
					}
					
					$("[name=na]").on("click", function() {
						sessionStorage.setItem("itmClick1", $(this).val());
						$("#avail").prop("disabled", true);
						$("#navail").prop("disabled", true);
						localStorage.setItem("did", $("#d").val());
						$("form").submit(function(){
								alert("Response saved");
						});
					});

				});
