# Spring-Halloween

Consignes : https://docs.google.com/document/d/1CgEd5D88D8DOj8qL0GHX2MjQ-Gt0hPm0XBwY3Ddzhgs
- Repository Front-End : https://github.com/jul-fls/spring_halloween_front (sang-min park inconnu au bataillon, il s'agit d'une erreur sur un commit où j'avais pas mis le bon nom de compte pour sangmin shim)
Bienvenue sur le dépôt Git de Spring-Halloween, un site web dédié à la vente de produits pour Halloween, tels que des bonbons, des masques de citrouille, et bien d'autres choses encore.

## Présentation du site web

Vous pouvez accéder au site web via les liens suivants :

- FrontEnd : [https://spring-halloween-front.flusin.fr/](https://spring-halloween-front.flusin.fr/)
- BackEnd : [https://spring-halloween-api.flusin.fr/](https://spring-halloween-api.flusin.fr/)

## Explications sur l'API REST

Notre API REST permet d'interagir avec les ressources suivantes :

### 1) Utilisateur (/user)

- Création d'un compte utilisateur
- Authentification et gestion de session
- Modification des informations du compte
- Suppression du compte utilisateur

| POST | GET | DELETE | PUT |
| -------- | -------- | -------- | -------- |
| /create | /getAll , /get?id=1 | /delete?id=1 | /update |
| + requestbody | - | + requestparam | + requestbody |

----

### 2) Produit (/product)

- Liste des produits disponibles
- Recherche de produits par catégorie ou nom
- Affichage des détails d'un produit spécifique


| POST | GET | DELETE | PUT |
| -------- | -------- | -------- | -------- |
| /create | /getAll , /get?id=1 | /delete?id=1 | /update |
| + requestbody | - | + requestparam | + requestbody |

----

### 3) Entreprise (/enterprise)

- Informations sur l'entreprise
- Contact et support


| POST | GET | DELETE | PUT |
| -------- | -------- | -------- | -------- |
| /create | /getAll , /get?id=1 | /delete?id=1 | /update |
| + requestbody | - | + requestparam | + requestbody |

----

### 4) Order (/order)

- Création d'une nouvelle commande
- Affichage de l'historique des commandes d'un utilisateur
- Mise à jour et annulation d'une commande


| POST | GET | DELETE | PUT |
| -------- | -------- | -------- | -------- |
| /create | /getAll , /get?id=1 | /delete?id=1 | /update |
| + requestbody | - | + requestparam | + requestbody |

----

### 5) Adresse (/address)

- Gestion des adresses de livraison et de facturation
- Ajout, modification et suppression d'adresses


| POST | GET | DELETE | PUT |
| -------- | -------- | -------- | -------- |
| /create | /getAll , /get?id=1 | /delete?id=1 | /update |
| + requestbody | - | + requestparam | + requestbody |

----
## Règles de gestion 

- Un utilisateur  ne peut avoir qu'une seule entreprise

- Une entreprise ne peut avoir qu'un seul propriétaire

- Un utilisateur ne peut avoir qu'une seule adresse

- La date de création de l'entreprise est : la date de création IRL 

## Pour commencer

N'hésitez pas à nous faire part de vos commentaires et suggestions pour améliorer notre site web et notre API. Nous espérons que vous passerez un agréable moment à préparer votre fête d'Halloween avec Spring-Halloween !

## Contributeur

- Julien FLUSIN
- Quentin LAUNAY
- Sangmin SHIM
