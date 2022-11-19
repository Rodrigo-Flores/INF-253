Datos personales:
	- Nombre: Rodrigo Ignacio Flores Figueroa
	- ROL USM: 202173523-2
	- RUT: 21070159-1

Detalles de uso del programa:
	- El directorio cuenta con un unico archivo main.rkt, el cual se debe ejecutar desde el editor DrRacket.

Consideraciones:
	- En la primera la primera linea del programa se encuentra #lang scheme y ademas una deficion de espacio de trabajo extra. Esta se aniadio pues sin aquello la funcion built-in eval no se lograba usar.
	- la funcion umbral no esta preparada para tratar con un umbral no existente (ej: (umbral_cola '(0 1 2 3) 5 #\M).
	- en ningun caso se admiten indices negativos.

Detalles de las herramientas usadas:
	- Sistema Operativo (SO)
		PRETTY_NAME="Ubuntu 22.04.1 LTS"
		NAME="Ubuntu"
		VERSION_ID="22.04"
		VERSION="22.04.1 LTS (Jammy Jellyfish)"
		VERSION_CODENAME=jammy
		ID=ubuntu
		ID_LIKE=debian
		HOME_URL="https://www.ubuntu.com/"
		SUPPORT_URL="https://help.ubuntu.com/"
		BUG_REPORT_URL="https://bugs.launchpad.net/ubuntu/"
		PRIVACY_POLICY_URL="https://www.ubuntu.com/legal/terms-and-policies/privacy-policy"
		UBUNTU_CODENAME=jammy
	- DrRacket: El IDE tambien fue instalado con v8.7.
	- Racket (usando racket --version): Welcome to Racket v8.7 [cs].
