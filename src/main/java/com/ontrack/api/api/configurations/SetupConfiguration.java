package com.ontrack.api.api.configurations;

import com.ontrack.api.api.dao.AnoLetivo;
import com.ontrack.api.api.dao.Curso;
import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.AnoLetivoRepository;
import com.ontrack.api.api.repositories.CursoRepository;
import com.ontrack.api.api.repositories.ProfessorRepository;
import com.ontrack.api.api.repositories.UnidadeCurricularRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

/*
Classe que vai introduzir as unidades curriculares na base de dados quando a aplicação é iniciada,
mas apenas se não existirem unidades curriculares na base de dados.
 */
@Configuration
public class SetupConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UnidadeCurricularRepository unidadeCurricularRepository, AnoLetivoRepository anoLetivoRepository, CursoRepository cursoRepository, ProfessorRepository professorRepository){
        return args -> {
            if(unidadeCurricularRepository.findAll().isEmpty()) {

                AnoLetivo anoLetivo = new AnoLetivo("2022/2023");
                anoLetivoRepository.save(anoLetivo);

                Curso cursoLEI = new Curso("Licenciatura em Engenharia Informática", "LEI");
                Curso cursoLIG = new Curso("Licenciatura em Informática de Gestão", "LIG");
                Curso cursoLEIRT = new Curso("Licenciatura em Engenharia Informática e Redes de Telecomunicações", "LEIRT");
                cursoRepository.saveAll(List.of(cursoLEI, cursoLIG, cursoLEIRT));

                Professor maria = new Professor("Maria", "p1234@ulusofona.pt");
                professorRepository.save(maria);

                //LEI
                //1º ano - 1º semestre
                UnidadeCurricular fundamentosFisicaLEI = new UnidadeCurricular("Fundamentos de Física", "FF", "Fundamentos de Física",6, 1, 1, cursoLEI, anoLetivo);
                UnidadeCurricular fundamentosProgramacaoLEI = new UnidadeCurricular("Fundamentos de Programação", "FP", "Fundamentos de Programação",6 , 1, 1, cursoLEI, anoLetivo);
                UnidadeCurricular matematicaDiscretaLEI = new UnidadeCurricular("Matemática Discreta", "MD", "Matemática Discreta",6, 1, 1, cursoLEI, anoLetivo);
                UnidadeCurricular matematicaILEI = new UnidadeCurricular("Matemática I", "MATI", "Matemática I",6, 1, 1, cursoLEI, anoLetivo);
                UnidadeCurricular sistemasDigitaisLEI = new UnidadeCurricular("Sistemas Digitais", "SD", "Sistemas Digitais",6, 1, 1, cursoLEI, anoLetivo);

                //1º ano - 2º semestre
                UnidadeCurricular algebraLinearLEI = new UnidadeCurricular("Álgebra Linear", "AL", "Álgebra Linear", 5, 1, 2, cursoLEI, anoLetivo);
                UnidadeCurricular algoritmiaEstruturasDadosLEI = new UnidadeCurricular("Algoritmia e Estruturas de Dados", "AED", "Algoritmia e Estruturas de Dados",6, 1, 2, cursoLEI, anoLetivo);
                UnidadeCurricular arquiteturaComputadoresLEI = new UnidadeCurricular("Arquitetura de Computadores", "AC", "Arquitetura de Computadores",5, 1, 2, cursoLEI, anoLetivo);
                UnidadeCurricular competenciasComportamentaisLEI = new UnidadeCurricular("Competências Comportamentais", "CC", "Competências Comportamentais",4, 1, 2, cursoLEI, anoLetivo);
                UnidadeCurricular linguagensProgramacaoILEI = new UnidadeCurricular("Linguagens de Programação I", "LP1", "Linguagens de Programação I",5, 1, 2, cursoLEI, anoLetivo);
                UnidadeCurricular matematicaIILEI = new UnidadeCurricular("Matemática II", "MATII", "Matemática II",5, 1, 2, cursoLEI, anoLetivo);

                //2º ano - 1º semestre
                UnidadeCurricular arquiteturasAvancadasComputadoresLEI = new UnidadeCurricular("Arquiteturas Avançadas de Computadores", "AAC", "Arquiteturas Avançadas de Computadores",6, 2, 1, cursoLEI, anoLetivo);
                UnidadeCurricular baseDadosLEI = new UnidadeCurricular("Base de Dados", "BD", "Base de Dados",6, 2, 1, cursoLEI, anoLetivo);
                UnidadeCurricular linguagensProgramacaoIILEI = new UnidadeCurricular("Linguagens de Programação II", "LPII", "Linguagens de Programação II",6, 2, 1, cursoLEI, anoLetivo);
                UnidadeCurricular probabilidadesEstatisticaLEI = new UnidadeCurricular("Probabilidades e Estatística", "PE", "Probabilidades e Estatística",6, 2, 1, cursoLEI, anoLetivo);
                UnidadeCurricular sistemasOperativosLEI = new UnidadeCurricular("Sistemas Operativos", "SO", "Sistemas Operativos",6, 2, 1, cursoLEI, anoLetivo);

                //2º ano - 2º semestre
                UnidadeCurricular engenhariaRequisitosTestesLEI = new UnidadeCurricular("Engenharia de Requisitos e Testes", "ERT", "Engenharia de Requisitos e Testes",6, 2, 2, cursoLEI, anoLetivo);
                UnidadeCurricular processamentoImagemLEI = new UnidadeCurricular("Processamento de Imagem", "PI", "Processamento de Imagem",6, 2, 2, cursoLEI, anoLetivo);
                UnidadeCurricular programacaoWebLEI = new UnidadeCurricular("Programação Web", "PW", "Programação Web",6, 2, 2, cursoLEI, anoLetivo);
                UnidadeCurricular redesComputadoresLEI = new UnidadeCurricular("Redes de Computadores", "RC", "Redes de Computadores",6, 2, 2, cursoLEI, anoLetivo);
                UnidadeCurricular sistemasSuporteDecisaoLEI = new UnidadeCurricular("Sistemas de Suporte à Decisão", "SSD", "Sistemas de Suporte à Decisão",6, 2, 2, cursoLEI, anoLetivo);

                //3º ano - 1º semestre
                UnidadeCurricular computacaoDistribuidaLEI = new UnidadeCurricular("Computação Distribuída", "CD", "Computação Distribuída",5, 3, 1, cursoLEI, anoLetivo);
                UnidadeCurricular dataScienceLEI = new UnidadeCurricular("Data Science", "DS", "Data Science",5, 3, 1, cursoLEI, anoLetivo);
                UnidadeCurricular engenhariaSoftwareLEI = new UnidadeCurricular("Engenharia de Software", "ES", "Engenharia de Software",5, 3, 1, cursoLEI, anoLetivo);
                UnidadeCurricular interacaoHumanoMaquinaLEI = new UnidadeCurricular("Interação Humano-Máquina", "IHM", "Interação Humano-Máquina",5, 3, 1, cursoLEI, anoLetivo);

                //3º ano - 2º semestre
                UnidadeCurricular computacaoMovelLEI = new UnidadeCurricular("Computação Móvel", "CM", "Computação Móvel",5, 3, 2, cursoLEI, anoLetivo);
                UnidadeCurricular inteligenciaArtificialLEI = new UnidadeCurricular("Inteligência Artificial", "IA", "Inteligência Artificial",5, 3, 2, cursoLEI, anoLetivo);
                UnidadeCurricular segurancaInformaticaLEI = new UnidadeCurricular("Segurança Informática", "SI", "Segurança Informática",5, 3, 2, cursoLEI, anoLetivo);
                UnidadeCurricular sistemasInformacaoNuvemLEI = new UnidadeCurricular("Sistemas de Informação na Nuvem", "SIN", "Sistemas de Informação na Nuvem",5, 3, 2, cursoLEI, anoLetivo);

                //3º ano - Anual
                UnidadeCurricular trabalhoFinalCursoLEI = new UnidadeCurricular("Trabalho Final de Curso", "TFC", "Trabalho Final de Curso",20, 3, 3, cursoLEI, anoLetivo);



                //LIG
                //1º ano - 1º semestre
                UnidadeCurricular contabilidadeLIG = new UnidadeCurricular("Contabilidade", "CONT", "Contabilidade",6, 1, 1, cursoLIG, anoLetivo);
                UnidadeCurricular fundamentosProgramacaoLIG = new UnidadeCurricular("Fundamentos de Programação", "FP", "Fundamentos de Programação",6, 1, 1, cursoLIG, anoLetivo);
                UnidadeCurricular fundamentosSistemasInformacaoLIG = new UnidadeCurricular("Fundamentos de Sistemas de Informação", "FSI", "Fundamentos de Sistemas de Informação",7, 1, 1, cursoLIG, anoLetivo);
                UnidadeCurricular matematicaILIG = new UnidadeCurricular("Matemática I", "MATI", "Matemática I",6, 1, 1, cursoLIG, anoLetivo);
                UnidadeCurricular teoriaPraticaMarketingLIG = new UnidadeCurricular("Teoria e Prática de Marketing", "TPM", "Teoria e Prática de Marketing",5, 1, 1, cursoLIG, anoLetivo);

                //1º ano - 2º semestre
                UnidadeCurricular algoritmiaEstruturasDadosLIG = new UnidadeCurricular("Algoritmia e Estruturas de Dados", "AED", "Algoritmia e Estruturas de Dados",6, 1, 2, cursoLIG, anoLetivo);
                UnidadeCurricular calculoFinanceiroLIG = new UnidadeCurricular("Cálculo Financeiro", "CF", "Cálculo Financeiro",5, 1, 2, cursoLIG, anoLetivo);
                UnidadeCurricular competenciasComportamentaisLIG = new UnidadeCurricular("Competências Comportamentais", "CC", "Competências Comportamentais",4, 1, 2, cursoLIG, anoLetivo);
                UnidadeCurricular linguagensProgramacaoILIG = new UnidadeCurricular("Linguagens de Programação I", "LP1", "Linguagens de Programação I",5, 1, 2, cursoLIG, anoLetivo);
                UnidadeCurricular matematicaIILIG = new UnidadeCurricular("Matemática II", "MatII", "Matemática II",5, 1, 2, cursoLIG, anoLetivo);
                UnidadeCurricular metricasEmpresariaisLIG = new UnidadeCurricular("Métricas Empresariais", "ME", "Métricas Empresariais",5, 1, 2, cursoLIG, anoLetivo);

                //2º ano - 1º semestre
                UnidadeCurricular basesDadosLIG = new UnidadeCurricular("Bases de Dados", "BD", "Bases de Dados LIG",6, 2, 1, cursoLIG, anoLetivo);
                UnidadeCurricular instrumentosGestaoLIG = new UnidadeCurricular("Instrumentos de Gestão", "IG", "Instrumentos de Gestão LIG",6, 2, 1, cursoLIG, anoLetivo);
                UnidadeCurricular investigacaoOperacionalLIG = new UnidadeCurricular("Investigação Operacional", "IO", "Investigação Operacional LIG",6, 2, 1, cursoLIG, anoLetivo);
                UnidadeCurricular linguagensProgramacaoIILIG = new UnidadeCurricular("Linguagens de Programação II", "LP2", "Linguagens de Programação II LIG",6, 2, 1, cursoLIG, anoLetivo);
                UnidadeCurricular sistemasOperativosLIG = new UnidadeCurricular("Sistemas Operativos", "SO", "Sistemas Operativos LIG",6, 2, 1, cursoLIG, anoLetivo);

                //2º ano - 2º semestre
                UnidadeCurricular engenhariaRequisitosTestesLIG = new UnidadeCurricular("Engenharia de Requisitos e Testes", "ERT", "Engenharia de Requisitos e Testes LIG",6, 2, 2, cursoLIG, anoLetivo);
                UnidadeCurricular gestaoFinanceiraLIG = new UnidadeCurricular("Gestão Financeira", "GF", "Gestão Financeira LIG",6, 2, 2, cursoLIG, anoLetivo);
                UnidadeCurricular programacaoWebLIG = new UnidadeCurricular("Programação Web", "PW", "Programação Web LIG",6, 2, 2, cursoLIG, anoLetivo);
                UnidadeCurricular redesComputadoresLIG = new UnidadeCurricular("Redes de Computadores", "RC", "Redes de Computadores LIG",6, 2, 2, cursoLIG, anoLetivo);
                UnidadeCurricular sistemasSuporteDecisaoLIG = new UnidadeCurricular("Sistemas de Suporte à Decisão", "SSD", "Sistemas de Suporte à Decisão LIG",6, 2, 2, cursoLIG, anoLetivo);

                //3º ano - 1º semestre
                UnidadeCurricular dataMiningLIG = new UnidadeCurricular("Data Mining", "DM", "Data Mining LIG",5, 3, 1, cursoLIG, anoLetivo);
                UnidadeCurricular engenhariaSoftwareLIG = new UnidadeCurricular("Engenharia de Software", "ES", "Engenharia de Software LIG",5, 3, 1, cursoLIG, anoLetivo);
                UnidadeCurricular interacaoHumanoMaquinaLIG = new UnidadeCurricular("Interação Humano-Máquina", "IHM", "Interação Humano-Máquina LIG",5, 3, 1, cursoLIG, anoLetivo);
                UnidadeCurricular sistemasMoveisEmpresariaisLIG = new UnidadeCurricular("Sistemas Móveis Empresariais", "SME", "Sistemas Móveis Empresariais LIG",5, 3, 1, cursoLIG, anoLetivo);

                //3º ano - 2º semestre
                UnidadeCurricular auditoriaSistemasInformacaoLIG = new UnidadeCurricular("Auditoria de Sistemas de Informação", "ASI", "Auditoria de Sistemas de Informação LIG",4, 3, 2, cursoLIG, anoLetivo);
                UnidadeCurricular controloGestaoLIG = new UnidadeCurricular("Controlo de Gestão", "CG", "Controlo de Gestão LIG",3, 3, 2, cursoLIG, anoLetivo);
                UnidadeCurricular inteligenciaArtificialLIG = new UnidadeCurricular("Inteligência Artificial", "IA", "Inteligência Artificial LIG",5, 3, 2, cursoLIG, anoLetivo);
                UnidadeCurricular motivacaoLiderancaLIG = new UnidadeCurricular("Motivação e Liderança", "ML", "Motivação e Liderança LIG",3, 3, 2, cursoLIG, anoLetivo);
                UnidadeCurricular sistemasInformacaoNuvemLIG = new UnidadeCurricular("Sistemas de Informação na Nuvem", "SIN", "Sistemas de Informação na Nuvem LIG",5, 3, 2, cursoLIG, anoLetivo);

                //3º ano - Anual
                UnidadeCurricular trabalhoFinalCursoLIG = new UnidadeCurricular("Trabalho Final de Curso", "TFC", "Trabalho Final de Curso",20, 3, 3, cursoLIG, anoLetivo);



                //LEIRT
                //1º ano - 1º semestre
                UnidadeCurricular fundamentosFisicaLEIRT = new UnidadeCurricular("Fundamentos de Física", "FF", "Fundamentos de Física LEIRT",6, 1, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular fundamentosProgramacaoLEIRT = new UnidadeCurricular("Fundamentos de Programação", "FP", "Fundamentos de Programação LEIRT",6, 1, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular matematicaDiscretaLEIRT = new UnidadeCurricular("Matemática Discreta", "MATD", "Matemática Discreta LEIRT",6, 1, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular matematicaILEIRT = new UnidadeCurricular("Matemática I", "MATI", "Matemática I LEIRT",6, 1, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular sistemasDigitaisLEIRT = new UnidadeCurricular("Sistemas Digitais", "SD", "Sistemas Digitais LEIRT",6, 1, 1, cursoLEIRT, anoLetivo);

                //1º ano - 2º semestre
                UnidadeCurricular algebraLinearLEIRT = new UnidadeCurricular("Álgebra Linear", "AL", "Álgebra Linear LEIRT",5, 1, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular algoritmiaEstruturasDadosLEIRT = new UnidadeCurricular("Algoritmia e Estruturas de Dados", "AED", "Algoritmia e Estruturas de Dados LEIRT",6, 1, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular arquiteturaComputadoresLEIRT = new UnidadeCurricular("Arquitetura de Computadores", "AC", "Arquitetura de Computadores LEIRT",5, 1, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular fundamentosEletronicaLEIRT = new UnidadeCurricular("Fundamentos de Eletrónica", "FE", "Fundamentos de Eletrónica LEIRT",4, 1, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular linguagensProgramacaoILEIRT = new UnidadeCurricular("Linguagens de Programação I", "LPI", "Linguagens de Programação I LEIRT",5, 1, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular matematicaIILEIRT = new UnidadeCurricular("Matemática II", "MATII", "Matemática II LEIRT",5, 1, 2, cursoLEIRT, anoLetivo);

                //2º ano - 1º semestre
                UnidadeCurricular basesDadosLEIRT = new UnidadeCurricular("Bases de Dados", "BD", "Bases de Dados LEIRT",6, 2, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular fundamentosTelecomunicacoesLEIRT = new UnidadeCurricular("Fundamentos de Telecomunicações", "FT", "Fundamentos de Telecomunicações LEIRT",6, 2, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular linguagensProgramacaoIILEIRT = new UnidadeCurricular("Linguagens de Programação II", "LPII", "Linguagens de Programação II LEIRT",6, 2, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular sinaisSistemasLEIRT = new UnidadeCurricular("Sinais e Sistemas", "SS", "Sinais e Sistemas LEIRT",6, 2, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular sistemasOperativosLEIRT = new UnidadeCurricular("Sistemas Operativos", "SO", "Sistemas Operativos LEIRT",6, 2, 1, cursoLEIRT, anoLetivo);

                //2º ano - 2º semestre
                UnidadeCurricular computacaoMovelLEIRT = new UnidadeCurricular("Computação Móvel", "CM", "Computação Móvel LEIRT",6, 2, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular fundamentosPropagacaoRadiacaoLEIRT = new UnidadeCurricular("Fundamentos de Propagação e Radiação", "FPR", "Fundamentos de Propagação e Radiação LEIRT",6, 2, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular probabilidadeEstatisticaLEIRT = new UnidadeCurricular("Probabilidade e Estatística", "PE", "Probabilidade e Estatística LEIRT",6, 2, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular redesComputadoresLEIRT = new UnidadeCurricular("Redes de Computadores", "RC", "Redes de Computadores LEIRT",6, 2, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular sistemasTelecomunicacoesLEIRT = new UnidadeCurricular("Sistemas de Telecomunicações", "ST", "Sistemas de Telecomunicações LEIRT",6, 2, 2, cursoLEIRT, anoLetivo);

                //3º ano - 1º semestre
                UnidadeCurricular complementosRedeLEIRT = new UnidadeCurricular("Complementos de Rede", "CR", "Complementos de Rede LEIRT",9, 1, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular computacaoDistribuidaLEIRT = new UnidadeCurricular("Computação Distribuída", "CD", "Computação Distribuída LEIRT",5, 1, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular dataScienceLEIRT = new UnidadeCurricular("Data Science", "DS", "Data Science LEIRT",5, 1, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular engenhariaSoftwareLEIRT = new UnidadeCurricular("Engenharia de Software", "ES", "Engenharia de Software LEIRT",5, 1, 1, cursoLEIRT, anoLetivo);
                UnidadeCurricular projetoTelecomunicacoesLEIRT = new UnidadeCurricular("Projeto de Telecomunicações", "PT", "Projeto de Telecomunicações LEIRT",5, 1, 1, cursoLEIRT, anoLetivo);

                //3º ano - 2º semestre
                UnidadeCurricular computacaoNuvemLEIRT = new UnidadeCurricular("Computação na Nuvem", "CN", "Computação na Nuvem LEIRT",6, 3, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular comunicacoesViaRadioLEIRT = new UnidadeCurricular("Comunicações Via Rádio", "CVR", "Comunicações Via Rádio LEIRT",6, 3, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular projetoRedesInformaticasLEIRT = new UnidadeCurricular("Projeto de Redes Informáticas", "PRI", "Projeto de Redes Informáticas LEIRT",7, 3, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular redesComunicacoesSemFiosLEIRT = new UnidadeCurricular("Redes de Comunicações sem Fios", "RCF", "Redes de Comunicações sem Fios LEIRT",6, 3, 2, cursoLEIRT, anoLetivo);
                UnidadeCurricular segurancaInformaticaLEIRT = new UnidadeCurricular("Segurança Informática", "SI", "Segurança Informática LEIRT",5, 3, 2, cursoLEIRT, anoLetivo);

                unidadeCurricularRepository.saveAll(List.of(
                        //LEI
                        // 1º ano - 1º semestre
                        fundamentosFisicaLEI,
                        fundamentosProgramacaoLEI,
                        matematicaDiscretaLEI,
                        matematicaILEI,
                        sistemasDigitaisLEI,

                        // 1º ano - 2º semestre
                        algebraLinearLEI,
                        algoritmiaEstruturasDadosLEI,
                        arquiteturaComputadoresLEI,
                        competenciasComportamentaisLEI,
                        linguagensProgramacaoILEI,
                        matematicaIILEI,

                        // 2º ano - 1º semestre
                        arquiteturasAvancadasComputadoresLEI,
                        baseDadosLEI,
                        linguagensProgramacaoIILEI,
                        probabilidadesEstatisticaLEI,
                        sistemasOperativosLEI,

                        // 2º ano - 2º semestre
                        engenhariaRequisitosTestesLEI,
                        processamentoImagemLEI,
                        programacaoWebLEI,
                        redesComputadoresLEI,
                        sistemasSuporteDecisaoLEI,

                        // 3º ano - 1º semestre
                        computacaoDistribuidaLEI,
                        dataScienceLEI,
                        engenhariaSoftwareLEI,
                        interacaoHumanoMaquinaLEI,

                        // 3º ano - 2º semestre
                        computacaoMovelLEI,
                        inteligenciaArtificialLEI,
                        segurancaInformaticaLEI,
                        sistemasInformacaoNuvemLEI,

                        // 3º ano - Anual
                        trabalhoFinalCursoLEI,


                        //LIG
                        // 1º ano - 1º semestre
                        contabilidadeLIG,
                        fundamentosProgramacaoLIG,
                        fundamentosSistemasInformacaoLIG,
                        matematicaILIG,
                        teoriaPraticaMarketingLIG,

                        // 1º ano - 2º semestre
                        algoritmiaEstruturasDadosLIG,
                        calculoFinanceiroLIG,
                        competenciasComportamentaisLIG,
                        linguagensProgramacaoILIG,
                        matematicaIILIG,
                        metricasEmpresariaisLIG,

                        // 2º ano - 1º semestre
                        basesDadosLIG,
                        instrumentosGestaoLIG,
                        investigacaoOperacionalLIG,
                        linguagensProgramacaoIILIG,
                        sistemasOperativosLIG,

                        // 2º ano - 2º semestre
                        engenhariaRequisitosTestesLIG,
                        gestaoFinanceiraLIG,
                        programacaoWebLIG,
                        redesComputadoresLIG,
                        sistemasSuporteDecisaoLIG,

                        // 3º ano - 1º semestre
                        dataMiningLIG,
                        engenhariaSoftwareLIG,
                        interacaoHumanoMaquinaLIG,
                        sistemasMoveisEmpresariaisLIG,

                        // 3º ano - 2º semestre
                        auditoriaSistemasInformacaoLIG,
                        controloGestaoLIG,
                        inteligenciaArtificialLIG,
                        motivacaoLiderancaLIG,
                        sistemasInformacaoNuvemLIG,

                        // 3º ano - Anual
                        trabalhoFinalCursoLIG,


                        //LEIRT
                        // 1º ano - 1º semestre
                        fundamentosFisicaLEIRT,
                        fundamentosProgramacaoLEIRT,
                        matematicaDiscretaLEIRT,
                        matematicaILEIRT,
                        sistemasDigitaisLEIRT,

                        // 1º ano - 2º semestre
                        algebraLinearLEIRT,
                        algoritmiaEstruturasDadosLEIRT,
                        arquiteturaComputadoresLEIRT,
                        fundamentosEletronicaLEIRT,
                        linguagensProgramacaoILEIRT,
                        matematicaIILEIRT,

                        // 2º ano - 1º semestre
                        basesDadosLEIRT,
                        fundamentosTelecomunicacoesLEIRT,
                        linguagensProgramacaoIILEIRT,
                        sinaisSistemasLEIRT,
                        sistemasOperativosLEIRT,

                        // 2º ano - 2º semestre
                        computacaoMovelLEIRT,
                        fundamentosPropagacaoRadiacaoLEIRT,
                        probabilidadeEstatisticaLEIRT,
                        redesComputadoresLEIRT,
                        sistemasTelecomunicacoesLEIRT,

                        // 3º ano - 1º semestre
                        complementosRedeLEIRT,
                        computacaoDistribuidaLEIRT,
                        dataScienceLEIRT,
                        engenhariaSoftwareLEIRT,
                        projetoTelecomunicacoesLEIRT,

                        // 3º ano - 2º semestre
                        computacaoNuvemLEIRT,
                        comunicacoesViaRadioLEIRT,
                        projetoRedesInformaticasLEIRT,
                        redesComunicacoesSemFiosLEIRT,
                        segurancaInformaticaLEIRT
                ));

            }
        };
    }
}
