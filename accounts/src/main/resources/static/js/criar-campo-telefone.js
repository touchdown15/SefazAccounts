$(function(){
	
	var $nome = $('#nome');
	var $email = $('#email');
	var $senha = $('#senha');
	var $ddd = $('#ddd');
	var $numero = $('#numero');
	var $tipo = $('#tipo');
		
	var $contador = 1;
	
	$('#add-usuario').on('click', function(){
		
		var telefone = {
			ddd: $ddd.val(),
			numero: $numero.val(),
			tipo: $tipo.val()
		};
		
		var usuario = {
			nome: $nome.val(),
			email: $email.val(),
			senha: $senha.val(),
			lista_de_telefone: [
				telefone
			]
		};
		
		for(var i = 1; i < $contador; i++){
			var telefone = {
				ddd: $('#ddd'+i).val(),
				numero: $('#numero'+i).val(),
				tipo: $('#tipo'+i).val()
			};
			
			usuario.lista_de_telefone.push(telefone);
			
		}
		
		$.ajax({
			type: 'POST',
			url: '/api/usuarios',
			dataType: 'json',
			contentType: 'application/json',
			data: JSON.stringify(usuario),
			sucess: function(novoUsuario){
			
			},
			
			
		});
	
	
	});
	
	$('#add-linhas').on('click', function(){
	
		var telefone = {
			ddd: $ddd.val(),
			numero: $numero.val(),
			tipo: $tipo.val()
		};
		
		var contador = $contador;
	
		$('#table').append('<p>DDD <input type="text" id="ddd'+contador+'" required></p>'+
	                		'<p>Numero <input type="text" id="numero'+contador+'" required></p>'+
	                		'<p>Tipo <input type="text" id="tipo'+contador+'" required></p>');
	    
	    contador++;
	    $contador = contador;
	                		
	    
	
	
	});



});



