
'use strict'; // Use strict for wrapping functions to avoid problems later

// Add a Modernizr-test for the weird, inbetween, flexbox implementation
// in IE10/IE11, necessary for the "sticky" footer.
// (See https://github.com/Modernizr/Modernizr/issues/812)
// (This could be rolled into a custom Modernizr build in production later.)
Modernizr.addTest('flexboxtweener', Modernizr.testAllProps('flexAlign', 'end', true));

//detect IE
function detectIE() {
	var ua = window.navigator.userAgent;
	var msie = ua.indexOf('MSIE ');
	var trident = ua.indexOf('Trident/');
	if (msie > 0) {
		return true;
	}
	if (trident > 0) {
		return true
	}
	return false;
}

//fix IE doc real height
function fixIeDocHeight(){
	var ieVersion = detectIE();
	var ieHeight;
	if (ieVersion){
		//console.log($(document).height());
		ieHeight = $(document).height() + 100;
		$('body').height(ieHeight);
	}
}

fixIeDocHeight();

$(function(){// Handler for .ready() called.

	$.when(
		$.getScript( 'static/js/jquery-ui.js', function(){}),
		$.getScript( 'static/js/jquery.ui.touch-punch.js', function(){}),
		$.getScript( 'static/js/jquery.validate.js', function(){}),
		$.getScript( 'static/js/jquery.remodal.js', function(){}),
		$.getScript( 'static/js/jquery.cookie.js', function(){}),
		//$.getScript( 'list.min.js', function(){}),

		$.getScript( 'static/js/main2.js', function(){}),
		$.Deferred(function( deferred ){
			$( deferred.resolve );
		})
	).done(function(){

		/*___________________________________________________________________*/
		// Toggle submenu's
		function toggleSubmenu(){
			$('.site-nav > li > a').on('click', function (event) {
				if ($(this).siblings().size() > 0){
					event.preventDefault();
					$(this).nextAll('.sub').toggleClass('expanded');
				}
			});
		}

		// Toggle secondary Bar
		function toggleSecondaryBar(){
			var $trigger = $('a.expand-collapse' , 'aside.secondary');
			$trigger.draggable({ axis: 'y' });
			$trigger.on('click', function (event) {
				event.preventDefault();
				$(this).toggleClass('active');
				$('.secondary').toggleClass('expanded');
			});
		}

		// Toggle contact form
		function toggleContact(){
			$('.contact-trigger').on('click', function (event) {
				event.preventDefault();
				$('#feedback').toggleClass('expanded');
			});
		}

		// Show/hide Search nav link & Toggle top search bar
		function toggleSearch(){
			var $sForm = $('form.search-form');
			var $sTrigger = $('a.search-trigger');

			$sTrigger.on('click', function (event) {
				event.preventDefault();
				$sForm.toggleClass('expanded');
			});

		}
//expande el main meno
		// Toggle cPanel
		function togglecPanel(){
			var $userCpanel = $('div.user-cpanel');
			var $cpanelTrigger = $('a.user-cpanel-trigger');
			
			$cpanelTrigger.on('click', function (event) {
				event.preventDefault();
				$userCpanel.toggleClass('expanded'); 
			});
//if usr clicks outside the panel, hide it
			$(document).mouseup(function (el){
				var container = $userCpanel;
				if(!container.is(el.target) && container.has(el.target).length === 0){
					container.removeClass('expanded');
				}
			});
		}

		toggleSubmenu();
		toggleSecondaryBar();
		toggleContact();
		toggleSearch();
		togglecPanel();
		
		/*___________________________________________________________________*/
		//create warning element
		function createWarning(){
			var $warEl = $( '<p class="messageDisplay warning clearfix"><span></span><i class="fa fa-times-circle"></i></p>');
	  		$('.wrapper').prepend($warEl);
		}
		createWarning();

		/*___________________________________________________________________*/
		//fade out the error when user clicks x
		function byeErrors(){
			$('.warning .fa').on('click', function (){
				$(this).parent().addClass('collapsed');
			});
		}
		byeErrors();

		/*___________________________________________________________________*/
		//Cookie handling
                //AGREGAR

		/*___________________________________________________________________*/
		//Setup validation
		function validateForm(formId){
			//  Validate signup form on keyup and submit
			formId.validate({
				rules: {
					nombre: 'required',
					razon: 'required',
					codigo: 'required',
					pais: 'required',
					provincia: 'required',
					/*username: {
						required: true,
						minlength: 2
					},
					password: {
						required: true,
						minlength: 5
					},
					confirm_password: {
						required: true,
						minlength: 5,
						equalTo: '#password'
					},*/
					email: {
						required: true,
						email: true
					},
					description: 'required'
					/*topic: {
						required: "#newsletter:checked",
						minlength: 2
					},*/
					/*agree: "required"*/
				},
				messages: {
					nombre: 'Ingrese un nombre.',
					razon: 'Ingrese razÃ³n.',
					codigo: 'Ingrese cÃ³digo fiscal.',
					pais: 'Seleccione paÃ­s.',
					provincia: 'Ingrese provincia.',
					/*username: {
						required: "Please enter a username",
						minlength: "Your username must consist of at least 2 characters"
					},
					password: {
						required: "Please provide a password",
						minlength: "Your password must be at least 5 characters long"
					},
					confirm_password: {
						required: "Please provide a password",
						minlength: "Your password must be at least 5 characters long",
						equalTo: "Please enter the same password as above"
					},*/
					email: 'Ingrese un e-mail vÃ¡lido.'
					/*agree: "Please accept our policy"*/
				}
			});
		}
		//$Id del form a validar.
		validateForm($('#datosCompania'));
		validateForm($('#datosPersonales'));
		validateForm($('#modifyPassword'));
		validateForm($('#companyLink'));
		validateForm($('#selectCompany'));
		validateForm($('#login'));
		validateForm($('#feedback'));
		validateForm($('#newProduct'));
		validateForm($('#itemViewMessage'));



		//List.js
		function listSearch(){
			var companyList = new List('alpha-list', {
				valueNames: ['name' , 'city'],
				page: 20000,
				//plugins: [ ListPagination({}) ]
			});
		}
		listSearch();

		//Agregar clases a anchors segÃºn contenido
		function addNamesToList(){
			$("li" , "#alpha-list").each(function() {
				var child = $(this).children();
				child.attr('name' , child.html().slice(0,1))
			});
		}
		addNamesToList();

		//Control de upload img
		function validateUpload(el){
			el.bind('change', function(event) {
				//5120
				console.log(this.files[0].size);
				var ext = el.val().split('.').pop().toLowerCase();
				var elSize = this.files[0].size / 1024;
				var errTarget = $('.messageDisplay');
				var messageSize = "El tamaÃ±o de archivo (" + elSize + " KBytes) no puede sobrepasar los 5 MBytes (5120 KBytes)";
				var messageType = "El tipo de archivo es incorrecto, sÃ³lo se admiten imÃ¡genes";
				var targetTxt = errTarget.children().first();
				//check type
				if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
    				event.preventDefault(); //don't submit
    				errTarget.addClass('warningDisplay').removeClass('collapsed');
    				targetTxt.empty();
    				targetTxt.prepend(messageType);
					errTarget.show();
				} else {
					if (elSize > 5120){
						event.preventDefault(); //don't submit
						errTarget.addClass('warningDisplay').removeClass('collapsed');
						targetTxt.empty();
						targetTxt.prepend(messageSize);
						errTarget.show();
					}else{
						//go
					}
				}
			});
		}
		//ID del elemento que requiere validaciÃ³n de tamaÃ±o de archivo
		validateUpload($('#imageFile'));

	});//when done

});//ready