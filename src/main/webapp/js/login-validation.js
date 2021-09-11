
function validateLogin()
{	
	const login = document.getElementById("login").value;
	const password = document.getElementById("password").value;
	
	if ( isEmpty( login ) && isEmpty( password ) )
	{
		alert( "Login e Senha devem ser preenchidos!" )
		return false;
	}
	
	else if ( isEmpty( login ) )
	{
		alert( "O Login deve ser informado!" );
		return false;
	}

	else if ( isEmpty( password ) )
	{
		alert( "A sua senha deve ser informada" );
		return false;
	}
}

function isEmpty(str) 
{
    return !str.trim().length;
}
