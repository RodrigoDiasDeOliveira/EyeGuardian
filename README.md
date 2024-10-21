# EyeGuardian
aplicativo móvel(Android) que reconheça rostos, objetos e ambientes, fornecendo informações auditivas em tempo real para pessoas com deficiência visual. O aplicativo pode informar quem está por perto, identificar objetos e até mesmo orientar em ambientes desconhecidos.

!['EyeGuardian'](https://github.com/user-attachments/assets/fb4dfc3b-1463-42ea-8a4e-69e30c9a0fbe)



Funcionalidades Principais

Reconhecimento Facial:
O aplicativo poderia ser configurado para identificar rostos conhecidos, como familiares, amigos ou colegas de trabalho, e fornecer feedback auditivo dizendo, por exemplo, "Maria está ao seu lado."
IA Personalizável: O usuário poderia adicionar pessoas ao banco de dados através de uma interface simples (usando a câmera do dispositivo para capturar os rostos).

Reconhecimento de Objetos e Ambientes:
O aplicativo seria capaz de identificar objetos do cotidiano, como mesas, cadeiras, portas, e até eletrodomésticos, dizendo ao usuário o que está ao redor.
Também poderia fornecer descrições rápidas de ambientes, como "Você está em um quarto com três cadeiras e uma mesa."
Navegação em Ambientes Internos:

Utilizando tecnologia de IA, sensores do smartphone (como giroscópio e GPS) e dados de mapas internos (se disponíveis), o aplicativo poderia guiar a pessoa dentro de um prédio, ajudando a encontrar saídas ou salas específicas.

Feedback Auditivo em Tempo Real:
A resposta visual seria convertida em áudio, de forma a não sobrecarregar o usuário com informações desnecessárias. Isso pode ser feito por sintetizadores de voz como Google Text-to-Speech ou Amazon Polly.
Modo de Vibração ou Feedback Tátil: Em situações de sobrecarga auditiva (como em locais barulhentos), o app também poderia usar padrões de vibração para alertas e navegação.

Tecnologias Envolvidas:
Visão Computacional e Reconhecimento de Imagens:
OpenCV ou TensorFlow Lite para processar as imagens localmente no dispositivo.
API de Serviços na Nuvem: Como o Google Cloud Vision API, Microsoft Azure Face API ou Amazon Rekognition, para reconhecimento facial e de objetos.
NLP e Conversão de Texto para Voz:
Ferramentas de Processamento de Linguagem Natural (NLP) como Dialogflow ou Hugging Face para fornecer respostas mais naturais.
Text-to-Speech APIs: Para conversão das descrições visuais em feedback auditivo.
Integração com Sensores Móveis:
GPS e giroscópio para navegação em ambientes externos e internos, proporcionando orientações espaciais.

Atualizando:
Captura de Dados de GPS e Mapas
Função: Capturar a localização atual do usuário via GPS e usar APIs de mapas (Google Maps API) para fornecer informações sobre o ambiente em torno, como pontos de interesse e rotas.
Como Funciona:
O aplicativo irá capturar a posição atual usando o Google Location Services.
O usuário poderá receber informações contextuais sobre o ambiente baseado em sua localização, como a presença de obstáculos ou estabelecimentos próximos.
Mapas offline podem ser integrados para permitir que o app funcione sem conexão de dados.
2. Feedback Auditivo com Base em Proximidade
Função: Fornecer feedback auditivo sobre objetos detectados próximos ao usuário.
Como Funciona:
Ao usar a câmera para identificar objetos, o aplicativo poderá também gerar pequenas amostras de áudio para alertar sobre a distância ou direção desses objetos.
Usar áudio direcional (por exemplo, através de fones de ouvido) para indicar a localização aproximada de um objeto em relação ao usuário (à frente, à direita, à esquerda).
3. Integração de Serviços
Google Maps API: Para obter informações detalhadas sobre o ambiente, como o nome de ruas, pontos de interesse próximos e rotas acessíveis para deficientes visuais.
Android Location Services: Para capturar a localização atual em tempo real.
Android Text-to-Speech (TTS): Para converter os dados e as informações contextuais em feedback auditivo.

Arquitetura de servicos:
1. TensorFlow Lite (No Dispositivo Móvel)
Função: Realizar o reconhecimento facial e de objetos diretamente no dispositivo, sem a necessidade de conexão constante com a internet, o que melhora a eficiência e permite respostas rápidas em tempo real.
Como Funciona:
Treinar os modelos de reconhecimento de imagens e rostos utilizando TensorFlow.
Converter esses modelos para a versão TensorFlow Lite, otimizada para dispositivos móveis, garantindo que o processamento seja leve e rápido.
O modelo será carregado no aplicativo e usará a câmera do dispositivo para identificar rostos e objetos.

2. Azure Cognitive Services (API na Nuvem)
Função: Fornecer funcionalidades adicionais baseadas em nuvem, como reconhecimento avançado de objetos, processamento de linguagem natural (para gerar respostas auditivas), e análises mais complexas que requerem maior poder computacional.
Serviços Envolvidos:
Azure Face API: Para reconhecimento facial mais avançado ou quando o processamento local não for suficiente.
Azure Computer Vision API: Para identificar objetos e ambientes de forma mais precisa ou realizar análises mais detalhadas de imagens.
Azure Speech API: Para conversão de texto para fala (Text-to-Speech) e interpretação de comandos de voz do usuário.
Como Funciona:
Quando o processamento local (via TensorFlow Lite) não for suficiente, o aplicativo poderá fazer chamadas à API da Azure para obter uma resposta mais detalhada ou avançada.
O processamento mais pesado (como reconhecimento de ambientes complexos ou reconhecimento de voz em diferentes idiomas) pode ser delegado à nuvem.

3. Oracle Cloud Infrastructure (Backup e Armazenamento)
Função: Fornecer backup de dados de usuários, imagens processadas e histórico de interações, além de armazenar o banco de dados com os perfis de rostos conhecidos pelo usuário.
Serviços Envolvidos:
OCI Object Storage: Para armazenar dados de backup, como imagens de treinamento, perfis de usuários e dados de modelos de IA.
OCI Database: Para armazenar dados relacionados ao reconhecimento facial (banco de dados de rostos conhecidos), estatísticas de uso do aplicativo, e logs de interação.
Como Funciona:
Sempre que um novo rosto ou objeto for identificado e precisar ser armazenado, o aplicativo pode enviar esses dados para a Oracle Cloud para backup seguro.
Isso garante que, se o usuário trocar de dispositivo ou reinstalar o app, o histórico e as configurações estejam preservados.
Arquitetura Geral:
Dispositivo Móvel (App):

Executa TensorFlow Lite para o reconhecimento em tempo real de rostos e objetos.
Envia solicitações para a Azure Cognitive Services API quando for necessário processamento adicional ou quando o dispositivo não puder lidar com a carga local.
Interface acessível com feedback auditivo e/ou tátil usando Azure Speech.
Backend na Nuvem:

Azure Cognitive Services lida com processamento avançado e retornos rápidos para o aplicativo.
Oracle Cloud Infrastructure faz o backup e armazenamento de dados críticos, como perfis de reconhecimento facial e logs de interações.
Banco de Dados e Backup:

OCI Object Storage e OCI Database armazenam e gerenciam dados de usuários, imagens, e modelos de IA, garantindo segurança e disponibilidade dos dados.
Benefícios dessa Arquitetura:
Desempenho Local (TensorFlow Lite): A maior parte do processamento pode ser feita localmente, reduzindo a dependência de conexão com a internet.
Escalabilidade com Azure Cognitive Services: Funcionalidades mais avançadas podem ser realizadas via nuvem, permitindo uma aplicação leve no dispositivo, mas com capacidades robustas.
Backup Seguro com OCI: O uso da Oracle Cloud garante que os dados do usuário estejam sempre disponíveis e protegidos, mesmo em casos de falha de dispositivo ou desinstalação do aplicativo.

Estrutura do Projeto:
Organizamos o projeto de acordo com o padrão MVC, seguindo os princípios de S.O.L.I.D. e utilizando Java 8, Maven e Spring Boot.

src/
 └── main/
     ├── java/com/eyeguardian/
     │    ├── controller/
     │    │    └── RecognizedObjectController.java
     │    ├── model/
     │    │    ├── RecognizedObject.java
     │    │    └── LocationData.java
     │    ├── repository/
     │    │    └── RecognizedObjectRepository.java
     │    ├── service/
     │    │    ├── RecognizedObjectService.java
     │    │    ├── AudioFeedbackService.java
     │    │    └── LocationService.java
     │    └── config/
     │         └── AzureConfig.java
     └── resources/
         └── application.properties


         

1. Classe AudioFeedbackService (Serviço de Áudio)
Esta classe será responsável por converter os resultados do reconhecimento de objetos em feedback auditivo, usando o sistema Text-to-Speech (TTS) nativo do Android.

package com.eyeguardian.service;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

public class AudioFeedbackService {
    private TextToSpeech textToSpeech;

    public AudioFeedbackService(Context context) {
        textToSpeech = new TextToSpeech(context, status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.US);
            }
        });
    }

    public void speak(String message) {
        textToSpeech.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    public void shutdown() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}

****************************************************** *************************
2. Classe LocationData (Modelo de Dados de Localização)
Aqui está a classe que armazenará informações de localização capturadas pelo GPS.

package com.eyeguardian.model;

public class LocationData {
    private double latitude;
    private double longitude;
    private float accuracy;

    public LocationData(double latitude, double longitude, float accuracy) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
    }

    // Getters and Setters
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }
}

**************************************************** *********************************************
3. Classe LocationService (Serviço de Localização)
Esta classe será responsável por gerenciar os dados de localização usando Android Location Services.

package com.eyeguardian.service;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import androidx.core.app.ActivityCompat;
import com.eyeguardian.model.LocationData;

public class LocationService {
    private LocationManager locationManager;
    private LocationListener locationListener;

    public LocationService(Context context) {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public void startListening(Context context, LocationListener listener) {
        locationListener = listener;
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request permissions in the activity before proceeding
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
    }

    public void stopListening() {
        if (locationListener != null) {
            locationManager.removeUpdates(locationListener);
        }
    }

    public LocationData getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(null, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(null, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Handle permission issues
            return null;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            return new LocationData(location.getLatitude(), location.getLongitude(), location.getAccuracy());
        } else {
            return null;
        }
    }
}

**********************************************  *****************************************************
4. Atualização na RecognizedObjectController
Para incluir o feedback auditivo e a captura de localização ao salvar um objeto reconhecido.

package com.eyeguardian.controller;

import android.content.Context;
import com.eyeguardian.model.RecognizedObject;
import com.eyeguardian.model.LocationData;
import com.eyeguardian.service.RecognizedObjectService;
import com.eyeguardian.service.AudioFeedbackService;
import com.eyeguardian.service.LocationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecognizedObjectController {
    private final RecognizedObjectService recognizedObjectService;
    private final AudioFeedbackService audioFeedbackService;
    private final LocationService locationService;

    public RecognizedObjectController(RecognizedObjectService recognizedObjectService, AudioFeedbackService audioFeedbackService, LocationService locationService) {
        this.recognizedObjectService = recognizedObjectService;
        this.audioFeedbackService = audioFeedbackService;
        this.locationService = locationService;
    }

    @PostMapping("/objects")
    public RecognizedObject saveObject(@RequestBody RecognizedObject recognizedObject, Context context) {
        // Salvar o objeto reconhecido
        RecognizedObject savedObject = recognizedObjectService.saveObject(recognizedObject);

        // Fornecer feedback auditivo
        audioFeedbackService.speak("Object " + savedObject.getName() + " recognized with confidence " + savedObject.getConfidence());

        // Capturar a localização atual
        LocationData location = locationService.getCurrentLocation();
        if (location != null) {
            System.out.println("Location - Lat: " + location.getLatitude() + ", Lon: " + location.getLongitude());
        }

        return savedObject;
    }
}

 ***************************************************** ******************************************************
5. Classe AzureConfig (Config)
Configuração para integrar com Azure Cognitive Services.

package com.eyeguardian.config;

import com.microsoft.azure.cognitiveservices.vision.computervision.ComputerVisionClient;
import com.microsoft.azure.cognitiveservices.vision.computervision.ComputerVisionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureConfig {
    @Bean
    public ComputerVisionClient computerVisionClient() {
        String subscriptionKey = "your_subscription_key";
        String endpoint = "your_endpoint";
        return ComputerVisionManager.authenticate(subscriptionKey).withEndpoint(endpoint);
    }
}

****************************************************** ***************************
6. Arquivo application.properties
Configurações da aplicação.

properties
Copiar código
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
Para o melhor desenvolvimento desta aplicacao o autor sugere:

Roadmap de Desenvolvimento do Aplicativo

Fase 1: Planejamento e Preparação
Definição de Requisitos:

Identificar os requisitos do usuário.
Definir as funcionalidades principais do aplicativo (ex: reconhecimento de objetos, feedback auditivo, integração com GPS).

Escolha de Tecnologias:
Confirmar o uso de Java, Maven, Spring Boot, TensorFlow Lite, Azure Cognitive Services, e Oracle OCI.
Definir as versões das bibliotecas e ferramentas que serão utilizadas.

Configuração do Ambiente de Desenvolvimento:
Configurar IDE (por exemplo, IntelliJ ou Eclipse) para Java.
Instalar o Maven e criar o projeto inicial com a estrutura básica. 

*****************************************************************

Fase 2: Desenvolvimento da Infraestrutura
Criação da Estrutura do Projeto:

Organizar as pastas do projeto conforme a estrutura proposta (MVC).
Configurar o arquivo pom.xml com as dependências necessárias.
Implementação da Camada de Acesso a Dados:

Criar as classes de modelo (ex: RecognizedObject).
Implementar os repositórios (ex: RecognizedObjectRepository).
Implementação da Lógica de Negócio:

Criar os serviços (ex: RecognizedObjectService) para gerenciar a lógica de negócios.
Garantir que as classes atendam aos princípios S.O.L.I.D.
Implementação da Camada de Apresentação:

Criar controladores (ex: RecognizedObjectController) para gerenciar as requisições HTTP.
Definir as rotas da API.

*******************************

Fase 3: Integração de Funcionalidades
Integração com TensorFlow Lite:
Treinar e converter modelos de reconhecimento de objetos para o formato TensorFlow Lite.
Integrar o modelo no aplicativo Java.
Integração com Azure Cognitive Services:

Configurar a conta Azure e obter as credenciais necessárias.
Implementar chamadas de API para Azure Cognitive Services para recursos adicionais, como análise de imagem.
Implementação de Feedback Auditivo:

Configurar o sistema Text-to-Speech para fornecer feedback auditivo.
Integrar o feedback auditivo com a lógica de reconhecimento de objetos.
Integração de Localização (GPS):

Implementar a captura de dados de localização usando Android Location Services.
Integrar informações de mapas usando a Google Maps API.

*****************************************************************************************
Fase 4: Testes e Ajustes
Testes de Unidade e Integração:

Criar testes unitários para as classes de serviço e repositório.
Realizar testes de integração para garantir que todos os componentes funcionem em conjunto.
Testes de Usuário:

Realizar testes com usuários reais para obter feedback sobre a usabilidade do aplicativo.
Ajustar funcionalidades com base no feedback recebido.


*********************************************************************************************
Fase 5: Implementação e Lançamento
Configuração da Infraestrutura na Nuvem:
Configurar o Oracle OCI para backup de dados.
Garantir que o aplicativo possa acessar os serviços da Azure e Oracle.

Implantação do Aplicativo:
Preparar o aplicativo para lançamento na Google Play Store.(Nao leve tao a serio!)
Monitorar e corrigir bugs após o lançamento.
Passo a Passo para Implementação de Infraestrutura

Configurar o Projeto Java com Maven:
Criar um novo projeto Maven.
Adicionar as dependências necessárias ao pom.xml.
Configurar o Banco de Dados:

Criar um banco de dados no Oracle ou MySQL.
Configurar a conexão no arquivo application.properties.

Desenvolver Classes e Serviços:
Seguir a estrutura MVC para criar classes de modelo, repositórios e serviços.
Implementar a lógica de negócio conforme os requisitos definidos.

Integrar TensorFlow Lite e Azure:
Treinar modelos de IA em Python e convertê-los para TensorFlow Lite.
Configurar chamadas à Azure Cognitive Services para recursos de análise de imagem.

Implementar Funcionalidades de Localização:
Configurar as permissões necessárias para acessar o GPS.
Implementar a captura e uso de dados de localização em tempo real.

Testar e Ajustar o Aplicativo:
Criar um ambiente de testes com dados simulados.
Realizar testes de performance e usabilidade.

Preparar para Lançamento:
Revisar todo o código e documentação.(voce deveria~!!!)
Configurar o Oracle OCI para backup e armazenamento de dados.se nao tem conta tem de criar a conta!!!

