# Application Heroes of the Storm (HOTS)
---

# Description du projet

Ce projet a été effectué dans le cadre du cours d'android pendant la troisième année d'école d'ingénieur. Le projet devait utiliser une RecyclerView afin d'afficher les données récupérées à partir d'une API REST. Cette application a pour but d'afficher la liste des héros de Heroes of the Storm en utilisant une API créée par un ami pour son site internet. 



# Consignes respectées
- Utilisation de 2 écrans : un premier avec une liste et un second qui affiche le detail du héro
- Appel WebService à une API REST
- Stockage des données en cache
- Architecture MVC
- Utilisation d'une RecyclerView avec un Adapter dans la première activité et nouvelle utilisation dans la deuxième activité
- Affichage d'images avec Picasso
- Utilisation d'un Splash Screen


# Fonctionnalités

L'application est composé tout d'abord d'un Splash Screen, ensuite d'une activité affichant la liste des héros et enfin une activité qui affiche le détail du héros.

## Icone

Voici l'icone personnalisé de l'application

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/icon_appli.jpg" width="100"/>

## Splash Screen

Pendant le chargement de l'application le splash screen suivant apparait

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/SplashScreen.jpg" width="250"/>


## Liste des héros

La première activité affiche la liste des héros, que l'on récupère avec un appel à une API REST, en utilisant la RecyclerView et l'Adapter.

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/MainActivity(1).jpg" width="250"/> <img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/MainActivity(2).jpg" width="250"/>

On voit sur ces photos que les héros sont caractérisés par leurs noms, on retrouve aussi leur classe, ainsi que l'image qui leurs correspond que l'on recupère grace au lien fournit par l'API et l'utilisation de Picasso.



## Écran de détail

On retrouve ici les details de chaque héros avec l'utilisation de la Recyclerview pour afficher les différents paliers de talents car on récupere une liste de talent avec L'API.
Pour pouvoir récupérer toutes les informations nécessaire, un second appel API est effectué qui nous permet d'obtenir le detail du héros considéré.

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Details(1).jpg" width="250"/> <img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Details(2).jpg" width="250"/> <img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Details(3).jpg" width="250"/>
<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Details(4).jpg" width="250"/> <img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Details(5).jpg" width="250"/> <img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Details(6).jpg" width="250"/>

