1- curl -XPOST "ms-demo-client1:ms-demo-123@localhost:9999/oauth/token" -d "grant_type=password&username=ms-demo-admin&password=admin"

2- curl -XPOST "ms-demo-client1:ms-demo-123@localhost:9999/oauth/token" -d "grant_type=password&username=ms-demo-user&password=user"


3- essayer curl "localhost:8081/greetings", on doit avoir UnauthorizedException

4- creer une variable TOKEN
TOKEN=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0OTMzMjkxNDMsInVzZXJfbmFtZSI6Im1zLWRlbW8tdXNlciIsImF1dGhvcml0aWVzIjpbIlNIT1BfUkVBRCJdLCJqdGkiOiIzMWZiMzVjNS03Y2M3LTQwOWEtODEwNC1hMTBiNGUwODVjMzAiLCJjbGllbnRfaWQiOiJtcy1kZW1vLWNsaWVudDEiLCJzY29wZSI6WyJTSE9QIl19.ebqDDlLtQx0qY7GFF4f-EkWiOj4cS_KKYJGTHr1qsJp-9knGGKYnQ8iQ5yC7KaFArGv3sSGwWzzOsy98utSH7r4fz8uTxLH1whgZE7PkWoeGOhcfrtuSeWkflagurGmenoyyBwDShACtQZ9BWL2Ik1GkRVhh52AgninWF44cv-EALJ_SMg9KT25uM4nKFpinCmpQrEhP6QScCK-POn0Da0h3nO-eNoZNC6GnkWp9V9y8hBDFkTH5HlSyJLIgEigp7W7ZTuiYuxf1Fq-GHYFnR91QSN0XUIeTgl2vA7JnpqhSSEVGnVqScjlLWTtMJgoLXmQVOpBGrZqKi3vt4t9TVw

4- curl -H "Authorization: Bearer $TOKEN" "localhost:8081/greetings?name=aymen" : doir renvoyer un resultat


5- curl -XPOST -H "Authorization: Bearer $TOKEN" "localhost:8081/greetings" : envoie une exceprtion

6- Decommenter // .antMatchers("/**").authenticated()

7- curl -XPOST --data "name=aymen" "localhost:8081/greetings" et on doit avoir un resultat

8 - Rajouter .antMatchers(HttpMethod.POST, "/foo").hasAuthority("FOO_WRITE") 

9- curl -XPOST --data "name=aymen" -H "Authorization: Bearer $TOKEN" "localhost:8081/greetings" : doit avoir ForbiddenException:Access is denied parceque le token était généré avec ms-demo-user qui n'a pas le droit SHOP_WRITE

10- Faire etape 1 et etape 4

11- curl -XPOST --data "name=aymen" -H "Authorization: Bearer $TOKEN" "localhost:8081/greetings" : renvoie mnt un resultat pcq ms-demo-admin a le droit SHOP_WRITE


// jouer avec les certificats

1- Regenerer une autre cle publique en modifiant le mot de passe

2- rejouer le senario et obtenir invalid_token

3- modifier le mot da passe dans OAuth2ServerConfig en gardant la meme cle public, le serveur ne demarre pas java.security.UnrecoverableKeyException



