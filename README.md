***Como gerar o build e executar no docker com uma imagem do projeto

mvn clean package 

docker build -t alura/forum . 

docker run -p 8082:8082 -e SPRING_PROFILES_ACTIVE='dev' -e
FORUM_DATABASE_URL='jdbc:h2:mem:alura-forum' -e FORUM_DATABASE_USERNAME='sa' -e FORUM_DATABASE_PASSWORD='123456'
alura/forum