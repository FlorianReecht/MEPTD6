**TD 6 Mise en production**
============================

L'objectif de ce TP d'utiliser les différents outils 
1ère étape : déploiment d'un fichier HTML classique.

**1ère partie **
Mise en place d'un conteneur contenant une page 
HTML statique.
-----
La page web statique sera stockée sur un serveur web nginx.

Le but de cette partie est de créer une image docker qui contiendra un serveur NGINX ainsi que la page web statique. 

Cette image est crée à partir d'un "Dockerfile".
Le Dockerfile est un fichier qui permet de génerer des images docker à partir d'instructions. 

Les instructions de ce Dockerfile sont très simple :
-La première instruction : "FROM nginx" permet de récuperer la dernière version de l'image Nginx présente sur le dockerhub.
- Les deux autres instructions :  
COPY index.html /usr/share/nginx/html
COPY style.css /usr/share/nginx/html
Permettent de copier les fichiers index.html et style.css dans le dossier "html" de l'image nginx.

Pour lancer le Dockerfile, il faut se placer dans le dossier courant et lancer la commande "docker build -t "nom de l'image" . "
Le point permet d'executer le fichier dans le dossier courant.
La commande génerera l'image docker correspondante.

Une fois l'image génerer , il faut ensuite la lancer dans un conteneur à l'aide de la commande suivante : 
"docker run [OPTIONS] IMAGE [COMMAND] [ARG...]"

Pour lancer le serveur sur le port 80 on lance la commande suivante : docker run -p 80:80 -d nomImage.

Lorsque le conteneur est lancé , il est possible d'observer la page statique à l'adresse suivante : 
"localhost:80".

L'étape suivante à été le déploiment de ce conteneur sur un serveur distant à l'aide de la technologie mogenius qui permet de déployer des applications dans le cloud. 

Pour déployer une application , il faut tout d'abord créer un "cloud space" qui est un espace pour héberger l'application.

mogenius peut ensuite executer le projet depuis la branche git sur laquelle le projet a été poussé.
mogenius va donc génerer le projet et lancer sur le conteneur sur un serveur distant. Le projet est disponible à cette adresse. (l'adresse a ensuite été supprimée pour mettre en place la seconde partie du TP car la version gratuite de mogenius ne permet d'avoir que un seul espace à la fois).

Lien sur mogenius : 
https://meptd6-prod-td6miseenproduction-fodxjs.mo2.mogenius.io/

**Deuxième partie** : 
Conteneur du back end et connexion à la base de données distante
------
La deuxième étape de ce TP 



La base de donnée peut être directement crée depuis mogenius.
En effet, lors de la création d'un nouveau service, il est possible de créer un service de type "postgre".

Lors de la création, il est nécessaire de configurer certains paramètre du serveur Postgre.

La variable d'environement la plus importante est la variable
POSTGRE_PASSWORD. Afin de la garder secrète , il est possible de la crypter à l'aide d'un docker secret. 


La variable d'environement POSTGRES_USER permet de configurer le nom d'utilisateur de la base de données. Il est initialisé par défault à posgres_user.

la variable d'environement POSTGRE_DB permet de créer une base de données vide du nom choisi.
La base de données est accessible à l'addresse suivante : 
tcp-mo5.mogenius.io sur le port 55448. 

Il est possible de s'y connecter depuis pg admin en entrant le bon nom d'utilisateur le bon mot de passe et la bonne adresse.




Afin de connecter le back avec la base de données distante, 

Il est nécessaire de changer l'url de dans le fichier application.yaml

Le lancement de l'application Spring permettra de créer la base de données sur le serveur distant. 

Il suffit enfin de conteneuriser l'application backend de l'éxecuter et il est possible d'observer l'API.
Le dockerfile pour conteneuriser l'api est composé des commandes suivante : 
-On part de la base d'une image gradle
- On copie le code source java dans le conteneur 
- Le code est ensuite compilé à l'aide de la commande gradle build
- On repart ensuite d'une image java 
- Les fichiers compilés précedement sont ensuite copiés dans la nouvelle image.


 Malheuresment je rencontre une erreur sur l'execution du dockerfile que je n'ai pas eu le temps de corriger. 

 Mais lorsque le Dockerfile sera fonctionel, l'application l'application dans le conteneur fonctionnera grace à la base de données précedement mise sur le serveur distant grace à mogenius.
