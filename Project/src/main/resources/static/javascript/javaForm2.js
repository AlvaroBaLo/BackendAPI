const form = document.getElementById('registro-form');
const nombreInput = document.getElementById('nombre');
const apellidoInput = document.getElementById('apellido');
const emailInput = document.getElementById('email');
const passwordInput = document.getElementById('password');
const passwordConfirmInput = document.getElementById('password-confirm');

form.addEventListener('submit', (event) => {
	event.preventDefault();

	if (validarFormulario()) {
		alert('Registro exitoso');
		form.reset();
	}
});

function validarFormulario() {
  var nombre = document.getElementById("nombre").value;
  var email = document.getElementById("email").value;
  var contrasena1 = document.getElementById("contrasena1").value;
  var contrasena2 = document.getElementById("contrasena2").value;

  if (nombre == "" || email == "" || contrasena1 == "" || contrasena2 == "") {
    alert("Por favor, rellene todos los campos.");
    return false;
  }

  if (contrasena1 != contrasena2) {
    alert("Las contraseñas no coinciden.");
    return false;
  }

  return true;
}