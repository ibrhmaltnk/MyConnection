pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Kodları sürüm kontrol sisteminden (Git, SVN vs.) çekiyoruz
                git 'https://github.com/ibrhmaltnk/MyConnection.git'
            }
        }
        
        stage('Build') {
            steps {
                // Maven kullanarak projeyi inşa ediyoruz
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                // Testleri çalıştırıyoruz
                sh 'mvn test'
            }
        }
        
        stage('Report') {
            steps {
                // Test raporlarını oluşturuyoruz
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
    
    post {
        always {
            // Her durumda çalışan adımlar
            cleanWs() // Çalışma alanını temizle
        }
        success {
            // Başarılı olduğunda çalışan adımlar
            echo 'Build ve Test Başarılı!'
        }
        failure {
            // Başarısız olduğunda çalışan adımlar
            echo 'Build veya Test Başarısız!'
        }
    }
}