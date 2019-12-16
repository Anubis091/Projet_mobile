# Application Heroes of the Storm (HOTS)
---

# Description du projet

Ce projet a été effectué dans le cadre du cours d'android pendant la quatrième année d'école d'ingénieur. Le projet devait utiliser des fragments, du material design, une architecture MVC, Git en utilisant les branches et un appel WebService à une API REST. Cette application a pour but d'afficher la liste des héros et des maps de Heroes of the Storm en utilisant une API créée par un ami pour son site internet. 



# Consignes respectées
- Utilisation de plusieurs écrans : affichant des listes sous différentes et d'autres affichant les caractéristiques du héros ou de la map.
- Appel WebService à une API REST
- Stockage des données en cache
- Architecture MVC
- Utilisation d'une RecyclerView avec un Adapter dans la première activité et nouvelle utilisation dans la deuxième activité
- Affichage d'images avec Picasso
- Utilisation d'un Splash Screen
- Utilisation de différents fragments : ListFragment, CardFragment, TileFragment
- Material Design
- Git


# Fonctionnalités

L'application est composé tout d'abord d'un Splash Screen, ensuite d'une activité contenant plusieurs fragements affichant la liste des héros et des maps. De plus on retrouve deux autres activités l'une qui affiche le détail du héros et l'autre le détail de la map.

## Icone

Voici l'icone personnalisé de l'application

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/icon_appli.jpg" width="100"/>

## Splash Screen

Pendant le chargement de l'application le splash screen suivant apparait

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/SplashScreen.jpg" width="250"/>


## Liste des héros dans les 2 fragments

La premier fragment est un FragmentList affiche la liste des héros avec la classe correspondant aux héros, que l'on récupère avec un appel à une API REST. Le second fragment est un FragmentTile qui affiche différemment cette même liste de héros. 

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-183546.jpg" width="250"/> <img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-183605.jpg" width="250"/><img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-183614.jpg" width="250"/>

On voit sur ces photos que les héros sont caractérisés par leurs noms, on retrouve aussi leur classe pour la iste, ainsi que l'image qui leurs correspond que l'on recupère grace au lien fournit par l'API et l'utilisation de Picasso.



## Écran de détail des héros

On retrouve ici les details de chaque héros avec l'utilisation de la Recyclerview (à l'horizontal) pour afficher les différents paliers de talents car on récupere une liste de talent avec L'API. De plus, on peut cliquer sur chaque sorts et talents des Héros afin d'obtenir leurs détails dans une pop up. On retrouve aussi une Collapsing bar contenant l'image du héros et son nom, de plus cliquer sur l'image du héros dans la Collapsing bar ouvre directement une vidéo de guide associé à ce héros sur Youtube.

Pour pouvoir récupérer toutes les informations nécessaire, un second appel API est effectué qui nous permet d'obtenir le detail du héros considéré.

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-183620.jpg" width="250"/> <img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-183636.jpg" width="250"/> <img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-192701%5B1%5D.jpg" width="250"/>
<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-183646.jpg" width="250"/>

## Liste des maps
Le fragment Card affiche la liste des maps récupérée par un appel à une API REST, on retrouve l'image de la map et son nom.

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-183712.jpg" width="250"/> <img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-183724.jpg" width="250"/>

## Écran de détail des maps

On retrouve ici un texte qui décrit la map et une collapsing bar contenant l'image de la map ainsi que son nom. Pour pouvoir récupérer les informations de la map, on effectue un nouvel appel API.

<img src="https://github.com/Anubis091/Projet_mobile/blob/master/Image_Readme/Screenshot_20191216-183730.jpg" width="250"/>


