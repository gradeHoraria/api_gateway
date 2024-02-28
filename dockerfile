# Use a imagem base com o JDK para compilar o código
FROM openjdk:17-ea-jdk-oracle AS builder

# Configurar o diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml para instalar as dependências
COPY pom.xml .

# copiar todo o código fonte
COPY . . 

# Compilar o código
RUN ./mvnw package -DskipTests

# Copiar o artefato compilado para a imagem do Maven
FROM maven:3.8.5-openjdk-17 AS final

# Configurar o diretório de trabalho
WORKDIR /app

# copiar o arquivo jar do estágio anterior
COPY --from=builder /app/target/*.jar /app/api_gateway.jar

# Porta que a aplicação irá escutar
EXPOSE 8082

# Comando para executar a aplicação
CMD ["java", "-jar", "api_gateway.jar"]