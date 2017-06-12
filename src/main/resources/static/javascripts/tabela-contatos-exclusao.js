var Agenda = Agenda || {};

Agenda.ExcluirContato = (function(){
	function ExcluirContato (){
		this.exclusaoBtn = $('.js-exclusao-btn')
	}
	
	ExcluirContato.prototype.iniciar = function(){
		
		this.exclusaoBtn.on('click', onExclusaoBtnClicado.bind(this));
		
	}
	
	function onExclusaoBtnClicado(evento) {
		evento.preventDefault();
		var botaoClicado = $(evento.currentTarget);
		var url = botaoClicado.data('url');
		var objeto = botaoClicado.data('objeto');
		swal({
			title : 'Tem certeza?',
			text : 'Excluir "' + objeto
					+ '"? Você não poderá recuperar depois.',
			showCancelButton : true,
			confirmButtonColor : '#DD6B55',
			confirmButtonText : 'Sim, exclua agora!',
			closeOnConfirm : false
		}, onExcluirConfirmado.bind(this, url));
		
	}
	
	function onExcluirConfirmado(url) {
		$.ajax({
			url : url,
			method : 'DELETE',
			success : onExcluidoSucesso.bind(this),
			error : onErroExcluir.bind(this)
		});
	}

	function onExcluidoSucesso() {
		var urlAtual = window.location.href;
		var separador = urlAtual.indexOf('?') > -1 ? '&' : '?';
		var novaUrl = urlAtual.indexOf('excluido') > -1 ? urlAtual : urlAtual
				+ separador + 'excluido';

		window.location = novaUrl;
	}

	function onErroExcluir(e) {
		swal('Oops!', 'Erro ao excluir, informe ao Administrador.', 'error');
	}
	
	
	return ExcluirContato;
	
}());

$(function(){
	
	var excluirContato = new Agenda.ExcluirContato();
	excluirContato.iniciar();
})