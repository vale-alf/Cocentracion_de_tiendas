

function login() {

  var usuario = document.getElementById("usuario").value;
  var password = document.getElementById("password").value;
  var logged;

  if (usuario === "Admin" && password === "123") {
    alert("Entrando como Admin...");
    logged = true;
    localStorage.setItem("logged", true);
    localStorage.setItem("checkAdmin", true);
    window.open('/Principal/Panel', '_self');
  }
  else if (usuario === "user" && password === "123") {
    alert("Entrando...");
    logged = true;
    localStorage.setItem("logged", true);
    localStorage.setItem("checkAdmin", false);
    window.open('/Usuario/Panel' , '_self');
  }
  else if (usuario === "" && password === "") {
    alert("Agregue su usuario y contraseña");
  }
  else if (usuario === "") {
    alert("Aun no ha ingresado el usuario");
  }
  else if (password === "") {
    alert("Aun no ha ingresado la contraseña");
  }
  else { alert("Usuario o contraseñas incorrectas"); }
  /*
  if (localStorage.length > 0){

    var listaFoodtrucks = JSON.parse(localStorage.getItem("foodtruck"));

    if (usuario !== "adm" || password !== "1234"){

      for (i=0; i<listaFoodtrucks.length; i++){
          if (usuario === listaFoodtrucks[i].login && password === listaFoodtrucks[i].senha){
            alert("Logado com sucesso!");
            logged = true;
            localStorage.setItem("id_foodtruck_logado", listaFoodtrucks[i].codigo_foodtruck);
            localStorage.setItem("logged", true);
            localStorage.setItem("checkAdmin", false);
            window.open('index.html', '_self');
          }
      }
    } else if (usuario === "adm" && password === "1234") {
      alert("Entrando como Admin...");
      logged = true;
      localStorage.setItem("logged", true);
      localStorage.setItem("checkAdmin", true);
      window.open('index.html', '_self');
    }

    if (logged !== true) alert("E-mail e/ou senha inválidos!");

  } else if (usuario === "adm" && password === "1234") {
    alert("Entrando como Admin...");
    logged = true;
    localStorage.setItem("logged", true);
    localStorage.setItem("checkAdmin", true);
    window.open('index.html', '_self');
  }
  else  alert("Ainda não existem Food Trucks cadastrados!\nFavor entrar em contato com o Administrador...");
  */
}


function recuperarCuenta() {
  let emailInput = document.getElementById("email");
  console.log(emailInput.value);
  let emailValue = emailInput.value;
  let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // Expresión regular para validar correo electrónico

  if (emailRegex.test(emailValue)) {
    alert("El correo electrónico para recuperar la cuenta, ha sido enviado exitosamente")
    //enviarCorreo();
    window.open('index.html', '_self');

  } else {
    alert("El correo electrónico no es válido");
  }
}


function enviarCorreo() {
  let emailInput = document.getElementById("email");
  let emailValue = emailInput.value;
  let sendgridApiKey = "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"; // Aquí debes ingresar tu API Key de SendGrid

  let sendgrid = window.SG;
  sendgrid.setApiKey(sendgridApiKey);



  const msg = {
    to: emailValue,
    from: 'lovgokmod@gmail.com',
    subject: 'Recuperacion de cuenta',
    text: 'Tu contraseña es: 1234'
  };

  sendgrid.send(msg)
    .then(() => {
      alert("El correo electrónico ha sido enviado exitosamente");
    })
    .catch((error) => {
      console.error(error);
      alert("Ha ocurrido un error al enviar el correo electrónico");
    });
}

function registrarse() {

  var nombre = document.getElementById("nombre").value;
  var apellido = document.getElementById("apellido").value;
  var usuario = document.getElementById("usuario").value;
  var contra = document.getElementById("password").value;
  var email = document.getElementById("email").value;
  var fechanaci = document.getElementById("password").value;

  if (nombre === "" || apellido === ""|| usuario === "" || contra === "" || email === "" || fechanaci === "") {
    alert("Por favor, llene todos los campos.");
  } 
  else{
    alert("Gracias!!. Ya te has registrado, ingresa esta vez a tu cuenta");
    
    window.open('index.html', '_self');
    //aqui tiene que ir el metodo para registrarse en la bd
  }

  

}
