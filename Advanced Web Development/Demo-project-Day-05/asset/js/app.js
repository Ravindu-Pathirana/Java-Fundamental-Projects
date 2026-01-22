document.getElementById("btn-register").addEventListener("click", btnRegister);

function btnRegister() {
  let firstname = document.getElementById("first-name").value;
  let lastname = document.getElementById("last-name").value;
  let province = document.getElementById("province").value;

  if (firstname === "" || lastname === "" || province === "") {
    alert("Please fill in all fields.");
    return;
  }

  let userData = {
    firstname: firstname,
    lastname: lastname,
    province: province,
  };

  console.log("Registering user:", userData);

  alert("Registration successful!");

  fetch("http://localhost:8080/student", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(userData),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Server response:", data);
    })
    .catch((error) => {
      console.error("Error during registration:", error);
    });
}
