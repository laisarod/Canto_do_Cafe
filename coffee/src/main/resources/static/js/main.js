window.toggleFavorito = function(element){
    element.classList.toggle("ativo");
    element.innerHTML = element.classList.contains("ativo") ? '❤️' : '♡';
}


function adicionarComentario() {
  const nome = document.getElementById("nome").value; 
  const comentario = document.getElementById("comentario-item").value;

  if (comentario.trim() == "" || nome.trim() == "") {
    alert("Digite um comentário antes de enviar");
    return;
  }

  const comentarioItem = document.createElement("div");
  comentarioItem.className = "comentario-item";

  const avatar = document.createElement("img");
  avatar.src = "images/xicara-de-cafe.png";

  const textoComentario = document.createElement("div");
  textoComentario.className = "comentario-texto";

  textoComentario.innerHTML = `
    <h3>${nome}</h3>
    <div class="estrelas">★★★★★</div>
    <p>${comentario}</p>
  `;

  comentarioItem.appendChild(avatar);
  comentarioItem.appendChild(textoComentario);

  const lista = document.getElementById("listarComentarios");
  lista.appendChild(comentarioItem);

  // Limpar campos
  document.getElementById("nome").value = ""; 
  document.getElementById("comentario-item").value = "";
}
