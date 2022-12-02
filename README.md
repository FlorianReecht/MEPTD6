**TD 6 Mise en production**
============================

1ère étape : déploiment d'un fichier HTML classique

Le dockerFile télecharge l'image Ngnix et copie le fichier 
index.html dans le dossier html de l'image Ngnix

Récupération du dockerFile et de l'indexhtml sur mogenius depuis la liaison sur github



Lien sur mogenius : 
https://meptd6-prod-td6miseenproduction-fodxjs.mo2.mogenius.io/

Deuxième étape : 

Liaison BDD et Api backend

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
