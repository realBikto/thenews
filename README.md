<div id="top"></div>


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/realBikto/thenews">
    <img src="src/main/resources/images/News_of_the_World_(film)_Logo.png" alt="Logo" height="80">
  </a>
<h3 align="center">News of the World - TFG Victor Herrera</h3>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

<!-- START ABSTRACT HERE -->

There are many great README templates available on GitHub; however, I didn't find one that really suited my needs so I created this enhanced one. I want to create a README template so amazing that it'll be the last one you ever need -- I think this is it.

Here's why:
* Your time should be focused on creating something amazing. A project that solves a problem and helps others
* You shouldn't be doing the same tasks over and over like creating a README from scratch
* You should implement DRY principles to the rest of your life :smile:

Of course, no one template will serve all projects since your needs may be different. So I'll be adding more in the near future. You may also suggest changes by forking this repo and creating a pull request or opening an issue. Thanks to all the people have contributed to expanding this template!

Use the `BLANK_README.md` to get started.

<!-- END ABSTRACT HERE -->

<p align="right">(<a href="#top">back to top</a>)</p>


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

