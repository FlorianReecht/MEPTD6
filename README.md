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


Afin de créer le service de l'application, il a été nécessaire de supprimer le lien de l'application HTML statique. 


La base de donnée peut être directement crée depuis mogenius.
Configuration des variables d'environement : 

Afin de se connecter avec l'application , certaines variables 
doivent être paramétrées afin de se connecter la base de données 
avec l'application backend.

La variable d'environement la plus importante est la variable
POSTGRE_PASSWORD. Afin de la garder secrète , il est possible de la crypter à l'aide d'un docker secret. 

Le docker secret peut être utilisé directement depuis mogenius 
Ou dans le dockerFile qui configure la base de données.

La variable POSTGRES_USER permet de configurer le nom d'utilisateur de la base de données. Il est initialisé par défault à posgres_user.

tcp-mo5.mogenius.io:14243 permet d'accéder à la base de données distante hébergée sur mogenius.

Afin de connecter le back avec la base de données distante, 

Il est nécessaire de changer l'url de dans le fichier application.yaml

Le lancement de l'application Spring permettra de créer la base de données sur le serveur distant. 

Il suffit enfin de conteneuriser l'application backend de l'éxecuter et il est possible d'observer l'API.
