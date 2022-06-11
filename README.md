<div id="top"></div>


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/realBikto/thenews">
    <img src="src/main/resources/img/logo.png" alt="Logo" height="80">
  </a>
<h3 align="center">News of the World - TFG Victor Herrera</h3>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

As we all know, we are in the information era, where with just one click we can find thousands of news, some truthful and others not, the well-known fake news. Often, people need a trusted page where they can read information that, in their opinion, is truthful and accurate.

For this reason, I have decided to implement the News of the World application. This application is a web page, where we can find articles categorized in six major blogs of different natures, implemented to be accessed through any web browser on any computer. To get into this project, we have performed a first search of the background on the news and I have made a study to know how it should be the most suitable structure to solve this need. In addition, it is an open source application, where anyone in the world can consult the code, download it, modify it, make suggestions for improvement and run it just by accessing the Github repository.


<!-- GETTING STARTED -->
## How to run the app

Next, we will see what you need to have installed in order to download the application. To start a local copy, follow these simple steps.

### Prerequisites

In order to be able to run the application we must first have installed in our local computer different programs.
* **Java JDK**
  
    Download any version equal to or higher than 1.8. The latest version can be found at the following URL: https://adoptium.net.
  

* **Docker Desktop**

    To install it on our machine is enough to access its website and, depending on the operating system, download the file or follow the instructions. Below, it is specified how to download it:

   * MAC: Download from https://www.docker.com/products/docker-desktop
   * Windows: Download from https://www.docker.com/products/docker-desktop
   * Linux: Download from https://docs.docker.com/desktop/linux/install

    It is also necessary to have installed the Docker Compose plugin. We will already have this plugin on our machine if we have previously installed Docker Desktop. For more references you can consult this address: https://docs.docker.com/compose/install


* **Apache Maven**

  To download and install it, we can follow the instructions at the following address: https://maven.apache.org/install.html.


### Installation

For the installation of the application itself and its execution, following the next steps:

1. Clone the repository: 
   ```sh
   git clone https://github.com/realBikto/thenews.git.
   ```
2. From the same terminal, enter the folder of the project that has been cloned and execute the script called run_application.sh. This script makes three instructions that, in case of any error, can be launched separately. These instructions are:

   ```sh
   mvn clean package -DskipTests=true
   mvn docker:build
   docker-compose up
   ```
3. Once the application has started,  access it from a web browser following the URL http://localhost:8080.

<p align="right">(<a href="#top">back to top</a>)</p>

