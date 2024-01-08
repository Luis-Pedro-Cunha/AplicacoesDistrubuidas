package app;

import interfaces.medicointerface;
import interfaces.*;
import excepcoes.SemMedicosDisponiveisNessaData;
import excepcoes.MedicoNaoExiste;
import excepcoes.UtenteNaoExiste;
import excepcoes.*;

import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try
        {
            Registry r = LocateRegistry.getRegistry("localhost", 5090);
            int stopcondition = 0;
            int option0 = 0;
            String user = "";
            String pass0 = "";
            String pass1 = "";

            // Enquanto stopcondition for igual a 0 o cliente não pára de correr.
            while(stopcondition == 0)
            {
                //primeira opção, option0, controla o primeiro ciclo dentro do ciclo
                while (option0 < 1 || option0 > 6){
                    user = "";
                    pass0 = "";
                    pass1 = "";
                    System.out.println("\nQual o seu tipo de utilizador? \n" +
                            "(1) Admin \n" +
                            "(2) Médico \n" +
                            "(3) Funcionário \n" +
                            "(4) Utente \n" +
                            "(5) Familiar de Utente \n" +
                            "(6) Sair \n" +
                            "Escolha uma opção (ex.: 1): ");
                    option0 = Integer.parseInt(scanner.nextLine());
                    if (option0 < 1 || option0 > 6){
                        System.out.println("Opção inválida!");
                    }
                }
                // É criada uma segunda opção, option1, para ser possível selecionar uma das opções
                // e uma "fechadura", lock0, capaz de impedir o utilizador de entrar na sua "conta"
                // mediante uma resposta de user ou pass errados
                int option1 = 0;
                int lock0 = 0;
                if (option0 == 1){
                    option0 = 0;
                    admininterface ai = (admininterface) r.lookup("unisaude");
                    while (lock0 == 0)
                    {
                        System.out.println("Introduza o user seguido da password.");
                        System.out.println("User:");
                        user = scanner.nextLine();
                        System.out.println("Password:");
                        pass0 = scanner.nextLine();
                        String message1 = ai.loginadmin(user,pass0);
                        if(message1.contains("ERRO"))
                        {
                            lock0=0;
                            System.out.println(message1);
                        }
                        else
                        {
                            lock0=1;
                            System.out.println(message1);
                        }

                    }
                    System.out.println("Selecionou Admin.");
                    while (option1 < 1 || option1 > 10){
                        System.out.println("\nQue ação pretende executar? \n" +
                                "(1) Adicionar novo Médico \n" +
                                "(2) Adicionar novo Medicamento \n" +
                                "(3) Adicionar novo Funcionário \n" +
                                "(4) Consultar Médicos \n" +
                                "(5) Consultar Medicamentos \n" +
                                "(6) Consultar Funcionários \n" +
                                "(7) Consultar Médico Específico \n" +
                                "(8) Consultar Medicamento Específico \n" +
                                "(9) Consultar Funcionário Específico \n" +
                                "(10) Regressar ao menu anterior \n" +
                                "Escolha uma opção (ex.: 1): ");
                        option1 = Integer.parseInt(scanner.nextLine());
                        if (option1 < 1 || option1 > 10){
                            System.out.println("Opção inválida!");
                        }
                        if(option1 == 1){
                            option1 = 0;
                            System.out.println("Introduza os dados do médico (nome,NIF,número do cc,data de nascimento (AAAA-MM-DD),ID,especialidade,email): ");
                            String mediconovo = scanner.nextLine();
                            String[] medicopartes = mediconovo.split(",", -1);
                            if (medicopartes.length!=7){
                                System.out.println("ERRO_9: Insira o número correto de elementos!");
                            }else {
                                String message2 = ai.AdicionaMedico(medicopartes[0],medicopartes[1],medicopartes[2],LocalDate.parse(medicopartes[3]),medicopartes[4],medicopartes[5],medicopartes[6]);
                                if (message2.contains("ERRO")){
                                    System.out.println(message2);
                                }
                                else{
                                    System.out.println(message2);
                                }
                            }

                        } else if (option1 == 2) {
                            option1 = 0;
                            System.out.println("Introduza os dados do medicamento (nome,princípio ativo,dose): ");
                            String medicamentonovo = scanner.nextLine();
                            String[] medicamentopartes = medicamentonovo.split(",", -1);
                            if (medicamentopartes.length!=3){
                                System.out.println("ERRO_9: Insira o número correto de elementos!");
                            }else {
                                String message2 = ai.AdicionaMedicamento(medicamentopartes[0],medicamentopartes[1],medicamentopartes[2]);
                                System.out.println(message2);
                            }

                        } else if (option1 == 3) {
                            option1 = 0;
                            System.out.println("Introduza os dados do funionário (nome,NIF,número do cc,data de nascimento (AAAA-MM-DD),ID): ");
                            String funcionarionovo = scanner.nextLine();
                            String[] funcionariopartes = funcionarionovo.split(",", -1);
                            if (funcionariopartes.length!=5){
                                System.out.println("ERRO_9: Insira o número correto de elementos!");
                            }else {
                                String message2 = ai.AdicionaFuncionario(funcionariopartes[0],funcionariopartes[1],funcionariopartes[2],LocalDate.parse(funcionariopartes[3]),funcionariopartes[4]);
                                if (message2.contains("ERRO")){
                                    System.out.println(message2);
                                }
                                else{
                                    System.out.println(message2);
                                }
                            }

                        } else if (option1 == 4){
                            option1 = 0;
                            for ( String key : ai.getMedico().keySet()
                                 ) {
                                System.out.println(key + " - " + ai.getMedico().get(key));
                            }
                        } else if (option1 == 5) {
                            option1 = 0;
                            for ( String key : ai.getMedicamento().keySet()
                            ) {
                                System.out.println(key + " - " + ai.getMedicamento().get(key));
                            }
                        } else if (option1 == 6) {
                            option1 = 0;
                            for ( String key : ai.getFuncionario().keySet()
                            ) {
                                System.out.println(key + " - " + ai.getFuncionario().get(key));
                            }
                        } else if (option1 == 7) {
                            option1 = 0;
                            System.out.println("Introduza o ID do médico: ");
                            String num_trabalhador = scanner.nextLine();
                            System.out.println(ai.getMedicoEspecifico(num_trabalhador));
                        } else if (option1 == 8) {
                            option1 = 0;
                            System.out.println("Introduza o ID do medicamento: ");
                            String idmed = scanner.nextLine();
                            System.out.println(ai.getMedicamentoEspecifico(idmed));
                        } else if (option1 == 9) {
                            option1 = 0;
                            System.out.println("Introduza o ID do funcionário: ");
                            String num_funcionario = scanner.nextLine();
                            System.out.println(ai.getFuncionarioEspecifico(num_funcionario));
                        } else if (option1 == 10){
                            System.out.println("Regressando ao menu anterior...");
                        }
                    }

                } else if (option0 == 2) {
                    option0 = 0;
                    medicointerface mi = (medicointerface) r.lookup("unisaude");
                    while(lock0 == 0)
                    {
                        System.out.println("Introduza o user seguido da password.");
                        System.out.println("User:");
                        user = scanner.nextLine();
                        System.out.println("Password:");
                        pass0 = scanner.nextLine();
                        String message1 = mi.loginmedico(user,pass0);
                        if(message1.contains("ERRO"))
                        {
                            lock0=0;
                            System.out.println(message1);
                        }
                        else
                        {
                            lock0=1;
                            System.out.println(message1);
                        }

                    }
                    System.out.println("Selecionou Médico.");
                    while (option1 < 1 || option1 > 9){
                        System.out.println("\nQue ação pretende executar? \n" +
                                "(1) Adicionar ficha de utente \n" +
                                "(2) Adicionar medições a um utente \n" +
                                "(3) Adicionar Exame a um utente \n" +
                                "(4) Adicionar Prescrição a um utente \n" +
                                "(5) Consultar fichas de utente \n" +
                                "(6) Consultar Medicamentos \n" +
                                "(7) Consultar ficha de utente específica \n" +
                                "(8) Estatísticas \n" +
                                "(9) Regressar ao menu anterior \n" +
                                "Escolha uma opção (ex.: 1): ");
                        option1 = Integer.parseInt(scanner.nextLine());
                        if (option1 < 1 || option1 > 9){
                            System.out.println("Opção inválida!");
                        }
                        if (option1 == 1){
                            option1 = 0;
                            System.out.println("Introduza o ID de utente: ");
                            String numutente = scanner.nextLine();
                            String message2 = mi.AdicionaFichaUtente(numutente);
                            if(message2.contains("ERRO"))
                            {
                                System.out.println(message2);
                            }
                            else
                            {
                                System.out.println(message2);
                            }
                        } else if(option1 == 2){
                            option1 = 0;
                            System.out.println("Introduza o ID de utente seguido das medições efetuadas (ID do utente,peso,altura,tensão arterial,saturação de oxigénio): ");
                            String medicaonova = scanner.nextLine();
                            String[] medicaopartes = medicaonova.split(",", -1);
                            if (medicaopartes.length!=5){
                                System.out.println("ERRO_9: Insira o número correto de elementos!");
                            }else {
                                LocalDate data = LocalDate.now();
                                Double peso = Double.parseDouble(medicaopartes[1]);
                                Double altura = Double.parseDouble(medicaopartes[2]);
                                Integer tens_art = Integer.parseInt(medicaopartes[3]);
                                Integer sat_ox = Integer.parseInt(medicaopartes[4]);
                                Double imc_d = peso / (altura*altura);
                                Integer imc = imc_d.intValue();
                                mi.AdicionarMedicao(medicaopartes[0],data,peso,altura,tens_art,sat_ox,imc);
                                System.out.println("Medição adicionada com sucesso!");
                            }

                        } else if (option1 == 3) {
                            option1 = 0;
                            System.out.println("Introduza o ID de utente seguido do ID da consulta e dos parâmetros do exame efetuado (ID do utente,ID da consulta,tipo de exame,descrição,resultado): ");
                            String examenovo = scanner.nextLine();
                            String[] examepartes = examenovo.split(",", -1);
                            if (examepartes.length!=5){
                                System.out.println("ERRO_9: Insira o número correto de elementos!");
                            }else {
                                LocalDateTime data = LocalDateTime.now();
                                mi.AdicionarExame(examepartes[0],examepartes[1],data,examepartes[2],examepartes[3],examepartes[4]);
                                System.out.println("Exame adicionado com sucesso!");
                            }

                        } else if (option1 == 4) {
                            option1 = 0;
                            System.out.println("Introduza o ID de utente seguido do ID da consulta e dos parâmetros da prescrição efetuada (ID do utente,ID da consulta,ID do medicamento,indicações,duração): ");
                            String prescricaonova = scanner.nextLine();
                            String[] prescricaopartes = prescricaonova.split(",", -1);
                            if (prescricaopartes.length!=5){
                                System.out.println("ERRO_9: Insira o número correto de elementos!");
                            }else {
                                LocalDate data = LocalDate.now();
                                mi.AdicionarPrescricao(prescricaopartes[0],prescricaopartes[1],data,prescricaopartes[2],prescricaopartes[3],prescricaopartes[4]);
                                System.out.println("Prescrição adicionada com sucesso!");
                            }

                        } else if (option1 == 5) {
                            option1 = 0;
                            for ( String key : mi.getFichasUtente().keySet()) {
                                System.out.println(key + " - " + mi.getFichasUtente().get(key));
                            }
                        } else if (option1 == 6) {
                            option1 = 0;
                            for (String key : mi.getMedicamento().keySet()
                            ) {
                                System.out.println(key + " - " + mi.getMedicamento().get(key));
                            }
                        }else if (option1 == 7) {
                            option1 = 0;
                            System.out.println("Introduza o ID de utente: ");
                            String numutente = scanner.nextLine();
                            System.out.println(mi.getFichaUtenteEspecifico(numutente));
                        } else if (option1 == 8) {
                            Integer option2 = 0;
                            while (option2 < 1 || option2 > 10) {
                                System.out.println("\nQue ação estatística pretende observar? \n" +
                                        "(1) Média da altura dos utentes \n" +
                                        "(2) Média do peso dos utentes \n" +
                                        "(3) Mediana da altura dos utentes \n" +
                                        "(4) Mediana do peso dos utentes \n" +
                                        "(5) Utentes com maior e menor altura \n" +
                                        "(6) Utentes com maior e menor peso \n" +
                                        "(7) Utentes com maior e menor IMC \n" +
                                        "(8) Utentes em situação de risco (nivel de oxigénio baixo) \n" +
                                        "(9) Utentes em situação de risco (hipertensão) \n" +
                                        "(10) Regressar ao menu anterior \n" +
                                        "Escolha uma opção (ex.: 1): ");
                                option2 = Integer.parseInt(scanner.nextLine());
                                if (option2 < 1 || option2 > 10) {
                                    System.out.println("Opção inválida!");
                                }
                                if (option2 == 1){
                                    option2=0;
                                    System.out.println(mi.MediaAltura());
                                } else if (option2 == 2) {
                                    option2=0;
                                    System.out.println(mi.MediaPeso());
                                } else if (option2 == 3) {
                                    option2=0;
                                    System.out.println(mi.MedianaAltura());
                                } else if (option2 == 4) {
                                    option2=0;
                                    System.out.println(mi.MedianaPeso());
                                } else if (option2 == 5) {
                                    option2=0;
                                    System.out.println(mi.MaxMinAltura());
                                } else if (option2 == 6) {
                                    option2=0;
                                    System.out.println(mi.MaxMinPeso());
                                } else if (option2 == 7) {
                                    option2=0;
                                    System.out.println(mi.MaxMinImc());
                                } else if (option2 == 8) {
                                    option2=0;
                                    System.out.println(mi.RiscoOxiBaixo());
                                } else if (option2 == 9) {
                                    option2=0;
                                    System.out.println(mi.RiscoHipertensao());
                                } else if (option2 == 10) {
                                    option1 = 0;
                                    System.out.println("Regressando ao menu anterior...");
                                }
                            }
                        } else if (option1 == 9) {
                            System.out.println("Regressando ao menu anterior...");
                            }
                    }
                } else if (option0 == 3) {
                    option0 = 0;
                    funcionariointerface fi = (funcionariointerface) r.lookup("unisaude");
                    while(lock0 == 0)
                    {
                        System.out.println("Introduza o user seguido da password.");
                        System.out.println("User:");
                        user = scanner.nextLine();
                        System.out.println("Password:");
                        pass0 = scanner.nextLine();
                        String message1 = fi.loginfuncionario(user,pass0);
                        if(message1.contains("ERRO"))
                        {
                            lock0=0;
                            System.out.println(message1);
                        }
                        else
                        {
                            lock0=1;
                            System.out.println(message1);
                        }

                    }
                    System.out.println("Selecionou Funcionário.");
                    while (option1 < 1 || option1 > 4){
                        System.out.println("\nQue ação pretende executar? \n" +
                                "(1) Adicionar novo utente \n" +
                                "(2) Adicionar consulta \n" +
                                "(3) Consultar ficha de utente específica  \n" +
                                "(4) Regressar ao menu anterior \n" +
                                "Escolha uma opção (ex.: 1): ");
                        option1 = Integer.parseInt(scanner.nextLine());
                        if (option1 < 1 || option1 > 4){
                            System.out.println("Opção inválida!");
                        }
                        if(option1 == 1){
                            option1 = 0;
                            System.out.println("Introduza os dados do utente (nome,NIF,número do CC,data de nascimento,ID de utente,telefone,telefone familiar,email,morada): ");
                            String utentenovo = scanner.nextLine();
                            String[] utentepartes = utentenovo.split(",", -1);
                            if (utentepartes.length!=9){
                                System.out.println("ERRO_9: Insira o número correto de elementos!");
                            }else {
                                String message2 = fi.adicionaUtente(utentepartes[0],utentepartes[1],utentepartes[2],LocalDate.parse(utentepartes[3]),utentepartes[4],utentepartes[5],utentepartes[6],utentepartes[7],utentepartes[8]);
                                if (message2.contains("ERRO")){
                                    System.out.println(message2);
                                }
                                else{
                                    System.out.println(message2);
                                }
                            }

                        } else if (option1 == 2) {
                            option1 = 0;
                            System.out.println("Introduza o ID do médico seguido do ID de utente e dos parâmetros da consulta efetuada (ID do médico,ID de utente,observações): ");
                            String consultanova = scanner.nextLine();
                            String[] consultapartes = consultanova.split(",", -1);
                            if (consultapartes.length!=3){
                                System.out.println("ERRO_9: Insira o número correto de elementos!");
                            }else {
                                LocalDateTime data = LocalDateTime.now();
                                fi.AdicionarConsulta(data,consultapartes[0],consultapartes[1],consultapartes[2]);
                                System.out.println("Consulta adicionada com sucesso!");
                            }

                        } else if (option1 == 3) {
                            option1 = 0;
                            System.out.println("Introduza o ID de utente: ");
                            String numutente = scanner.nextLine();
                            System.out.println(fi.getFichaUtenteEspecifico(numutente));
                        } else if (option1 == 4) {
                            System.out.println("Regressando ao menu anterior...");
                        }
                    }
                } else if (option0 == 4) {
                    option0 = 0;
                    utenteinterface ui = (utenteinterface) r.lookup("unisaude");
                    while(lock0 == 0)
                    {
                        System.out.println("Introduza o user seguido da password.");
                        System.out.println("User:");
                        user = scanner.nextLine();
                        System.out.println("Password:");
                        pass0 = scanner.nextLine();
                        String message1 = ui.loginutente(user,pass0);
                        if(message1.contains("ERRO"))
                        {
                            lock0=0;
                            System.out.println(message1);
                        }
                        else
                        {
                            lock0=1;
                            System.out.println(message1);
                        }

                    }
                    System.out.println("Selecionou Utente.");
                    while (option1 < 1 || option1 > 3){
                        System.out.println("\nQue ação pretende executar? \n" +
                                "(1) Consultar ficha de utente \n" +
                                "(2) Adicionar familiar \n" +
                                "(3) Regressar ao menu anterior \n" +
                                "Escolha uma opção (ex.: 1): ");
                        option1 = Integer.parseInt(scanner.nextLine());
                        if (option1 < 1 || option1 > 3){
                            System.out.println("Opção inválida!");
                        }
                        if (option1 == 1){
                            option1 = 0;
                            System.out.println(ui.getFichaUtenteEspecifico(user));
                        } else if (option1 == 2) {
                            option1 = 0;
                            System.out.println("Introduza os dados do familiar (nome,NIF,número do CC,data de nascimento (AAAA-MM-DD),número de telemóvel,grau de parentesco): ");
                            String familiarnovo = scanner.nextLine();
                            String[] familiarpartes = familiarnovo.split(",", -1);
                            if (familiarpartes.length!=6){
                                System.out.println("ERRO_9: Insira o número correto de elementos!");
                            }else {
                                String message2 = ui.AdicionarFamiliarUtente(user,familiarpartes[0],familiarpartes[1],familiarpartes[2],LocalDate.parse(familiarpartes[3]),familiarpartes[4],familiarpartes[5]);
                                if (message2.contains("ERRO")){
                                    System.out.println(message2);
                                }
                                else{
                                    System.out.println(message2);
                                }
                            }

                        } else if (option1 == 3) {
                            System.out.println("Regressando ao menu anterior...");
                        }
                    }
                } else if(option0 == 5) {
                    option0 = 0;
                    familiarinterface fai = (familiarinterface) r.lookup("unisaude");
                    while(lock0 == 0)
                    {
                        System.out.println("Introduza o user seguido da password.");
                        System.out.println("User:");
                        user = scanner.nextLine();
                        System.out.println("Password 1:");
                        pass0 = scanner.nextLine();
                        System.out.println("Password 2:");
                        pass1 = scanner.nextLine();
                        String message1 = fai.loginfamiliar(user,pass0,pass1);
                        if(message1.contains("ERRO"))
                        {
                            lock0=0;
                            System.out.println(message1);
                        }
                        else
                        {
                            lock0=1;
                            System.out.println(message1);
                        }

                    }
                    System.out.println("Selecionou Familiar de Utente.");
                    while (option1 < 1 || option1 > 2){
                        System.out.println("\nQue ação pretende executar? \n" +
                                "(1) Consultar ficha de utente \n" +
                                "(2) Regressar ao menu anterior \n" +
                                "Escolha uma opção (ex.: 1): ");
                        option1 = Integer.parseInt(scanner.nextLine());
                        if (option1 < 1 || option1 > 2){
                            System.out.println("Opção inválida!");
                        }
                        if (option1 == 1){
                            option1 = 0;
                            System.out.println(fai.getFichaUtenteEspecifico(user));
                        } else if (option1 == 2) {
                            System.out.println("Regressando ao menu anterior...");
                        }
                    }
                } else {
                    System.out.println("A encerrar o cliente...");
                    stopcondition=1;
                }
            }

        } catch (RemoteException | NotBoundException e0) {
            e0.printStackTrace();
        }
    }
}