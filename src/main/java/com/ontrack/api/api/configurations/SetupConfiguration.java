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
                UnidadeCurricular fundamentosFisicaLEI = new UnidadeCurricular("Fundamentos de Física", "FF", "Fundamentos de Física",6, 1, 1, cursoLEI, anoLetivo, "DB592A");
                UnidadeCurricular fundamentosProgramacaoLEI = new UnidadeCurricular("Fundamentos de Programação", "FP", "Fundamentos de Programação",6 , 1, 1, cursoLEI, anoLetivo, "FFCE5D");
                UnidadeCurricular matematicaDiscretaLEI = new UnidadeCurricular("Matemática Discreta", "MD", "Matemática Discreta",6, 1, 1, cursoLEI, anoLetivo, "7CFF6D");
                UnidadeCurricular matematicaILEI = new UnidadeCurricular("Matemática I", "MATI", "Matemática I",6, 1, 1, cursoLEI, anoLetivo, "7BFFD2");
                UnidadeCurricular sistemasDigitaisLEI = new UnidadeCurricular("Sistemas Digitais", "SD", "Sistemas Digitais",6, 1, 1, cursoLEI, anoLetivo, "AD71FF");

                //1º ano - 2º semestre
                UnidadeCurricular algebraLinearLEI = new UnidadeCurricular("Álgebra Linear", "AL", "Álgebra Linear", 5, 1, 2, cursoLEI, anoLetivo, "FF749B");
                UnidadeCurricular algoritmiaEstruturasDadosLEI = new UnidadeCurricular("Algoritmia e Estruturas de Dados", "AED", "Algoritmia e Estruturas de Dados",6, 1, 2, cursoLEI, anoLetivo, "7EA1C4");
                UnidadeCurricular arquiteturaComputadoresLEI = new UnidadeCurricular("Arquitetura de Computadores", "AC", "Arquitetura de Computadores",5, 1, 2, cursoLEI, anoLetivo, "FF7368");
                UnidadeCurricular competenciasComportamentaisLEI = new UnidadeCurricular("Competências Comportamentais", "CC", "Competências Comportamentais",4, 1, 2, cursoLEI, anoLetivo, "FF8F4A");
                UnidadeCurricular linguagensProgramacaoILEI = new UnidadeCurricular("Linguagens de Programação I", "LP1", "Linguagens de Programação I",5, 1, 2, cursoLEI, anoLetivo, "FFDA86");
                UnidadeCurricular matematicaIILEI = new UnidadeCurricular("Matemática II", "MATII", "Matemática II",5, 1, 2, cursoLEI, anoLetivo, "A3FE7A");

                //2º ano - 1º semestre
                UnidadeCurricular arquiteturasAvancadasComputadoresLEI = new UnidadeCurricular("Arquiteturas Avançadas de Computadores", "AAC", "Arquiteturas Avançadas de Computadores",6, 2, 1, cursoLEI, anoLetivo, "FFFE77");
                UnidadeCurricular baseDadosLEI = new UnidadeCurricular("Base de Dados", "BD", "Base de Dados",6, 2, 1, cursoLEI, anoLetivo, "94FFC9");
                UnidadeCurricular linguagensProgramacaoIILEI = new UnidadeCurricular("Linguagens de Programação II", "LPII", "Linguagens de Programação II",6, 2, 1, cursoLEI, anoLetivo, "A0EFFF");
                UnidadeCurricular probabilidadesEstatisticaLEI = new UnidadeCurricular("Probabilidades e Estatística", "PE", "Probabilidades e Estatística",6, 2, 1, cursoLEI, anoLetivo, "96ACFF");
                UnidadeCurricular sistemasOperativosLEI = new UnidadeCurricular("Sistemas Operativos", "SO", "Sistemas Operativos",6, 2, 1, cursoLEI, anoLetivo, "D19DFF");

                //2º ano - 2º semestre
                UnidadeCurricular engenhariaRequisitosTestesLEI = new UnidadeCurricular("Engenharia de Requisitos e Testes", "ERT", "Engenharia de Requisitos e Testes",6, 2, 2, cursoLEI, anoLetivo, "FE9FFE");
                UnidadeCurricular processamentoImagemLEI = new UnidadeCurricular("Processamento de Imagem", "PI", "Processamento de Imagem",6, 2, 2, cursoLEI, anoLetivo, "C3CCFF");
                UnidadeCurricular programacaoWebLEI = new UnidadeCurricular("Programação Web", "PW", "Programação Web",6, 2, 2, cursoLEI, anoLetivo, "");
                UnidadeCurricular redesComputadoresLEI = new UnidadeCurricular("Redes de Computadores", "RC", "Redes de Computadores",6, 2, 2, cursoLEI, anoLetivo, "AFFFAE");
                UnidadeCurricular sistemasSuporteDecisaoLEI = new UnidadeCurricular("Sistemas de Suporte à Decisão", "SSD", "Sistemas de Suporte à Decisão",6, 2, 2, cursoLEI, anoLetivo, "EFFF6E");

                //3º ano - 1º semestre
                UnidadeCurricular computacaoDistribuidaLEI = new UnidadeCurricular("Computação Distribuída", "CD", "Computação Distribuída",5, 3, 1, cursoLEI, anoLetivo, "FFDD8D");
                UnidadeCurricular dataScienceLEI = new UnidadeCurricular("Data Science", "DS", "Data Science",5, 3, 1, cursoLEI, anoLetivo, "FEA173");
                UnidadeCurricular engenhariaSoftwareLEI = new UnidadeCurricular("Engenharia de Software", "ES", "Engenharia de Software",5, 3, 1, cursoLEI, anoLetivo, "FF6E6E");
                UnidadeCurricular interacaoHumanoMaquinaLEI = new UnidadeCurricular("Interação Humano-Máquina", "IHM", "Interação Humano-Máquina",5, 3, 1, cursoLEI, anoLetivo, "FF9DE3");

                //3º ano - 2º semestre
                UnidadeCurricular computacaoMovelLEI = new UnidadeCurricular("Computação Móvel", "CM", "Computação Móvel",5, 3, 2, cursoLEI, anoLetivo, "C5B7FF");
                UnidadeCurricular inteligenciaArtificialLEI = new UnidadeCurricular("Inteligência Artificial", "IA", "Inteligência Artificial",5, 3, 2, cursoLEI, anoLetivo, "9EE5FF");
                UnidadeCurricular segurancaInformaticaLEI = new UnidadeCurricular("Segurança Informática", "SI", "Segurança Informática",5, 3, 2, cursoLEI, anoLetivo, "A8FFCE");
                UnidadeCurricular sistemasInformacaoNuvemLEI = new UnidadeCurricular("Sistemas de Informação na Nuvem", "SIN", "Sistemas de Informação na Nuvem",5, 3, 2, cursoLEI, anoLetivo, "FDFFB5");

                //3º ano - Anual
                UnidadeCurricular trabalhoFinalCursoLEI = new UnidadeCurricular("Trabalho Final de Curso", "TFC", "Trabalho Final de Curso",20, 3, 3, cursoLEI, anoLetivo, "FFD7B0");



                //LIG
                //1º ano - 1º semestre
                UnidadeCurricular contabilidadeLIG = new UnidadeCurricular("Contabilidade", "CONT", "Contabilidade",6, 1, 1, cursoLIG, anoLetivo, "FFA6A4");
                UnidadeCurricular fundamentosProgramacaoLIG = new UnidadeCurricular("Fundamentos de Programação", "FP", "Fundamentos de Programação",6, 1, 1, cursoLIG, anoLetivo, "F6B6FF");
                UnidadeCurricular fundamentosSistemasInformacaoLIG = new UnidadeCurricular("Fundamentos de Sistemas de Informação", "FSI", "Fundamentos de Sistemas de Informação",7, 1, 1, cursoLIG, anoLetivo, "D9CAFF");
                UnidadeCurricular matematicaILIG = new UnidadeCurricular("Matemática I", "MATI", "Matemática I",6, 1, 1, cursoLIG, anoLetivo, "BEDAFF");
                UnidadeCurricular teoriaPraticaMarketingLIG = new UnidadeCurricular("Teoria e Prática de Marketing", "TPM", "Teoria e Prática de Marketing",5, 1, 1, cursoLIG, anoLetivo, "88C4FF");

                //1º ano - 2º semestre
                UnidadeCurricular algoritmiaEstruturasDadosLIG = new UnidadeCurricular("Algoritmia e Estruturas de Dados", "AED", "Algoritmia e Estruturas de Dados",6, 1, 2, cursoLIG, anoLetivo,"8DFAFF");
                UnidadeCurricular calculoFinanceiroLIG = new UnidadeCurricular("Cálculo Financeiro", "CF", "Cálculo Financeiro",5, 1, 2, cursoLIG, anoLetivo, "93FFC5");
                UnidadeCurricular competenciasComportamentaisLIG = new UnidadeCurricular("Competências Comportamentais", "CC", "Competências Comportamentais",4, 1, 2, cursoLIG, anoLetivo, "B2FFAA");
                UnidadeCurricular linguagensProgramacaoILIG = new UnidadeCurricular("Linguagens de Programação I", "LP1", "Linguagens de Programação I",5, 1, 2, cursoLIG, anoLetivo, "FEF48C");
                UnidadeCurricular matematicaIILIG = new UnidadeCurricular("Matemática II", "MatII", "Matemática II",5, 1, 2, cursoLIG, anoLetivo, "FFCB6B");
                UnidadeCurricular metricasEmpresariaisLIG = new UnidadeCurricular("Métricas Empresariais", "ME", "Métricas Empresariais",5, 1, 2, cursoLIG, anoLetivo, "FFA169");

                //2º ano - 1º semestre
                UnidadeCurricular basesDadosLIG = new UnidadeCurricular("Bases de Dados", "BD", "Bases de Dados LIG",6, 2, 1, cursoLIG, anoLetivo, "FF706C");
                UnidadeCurricular instrumentosGestaoLIG = new UnidadeCurricular("Instrumentos de Gestão", "IG", "Instrumentos de Gestão LIG",6, 2, 1, cursoLIG, anoLetivo, "F491FF");
                UnidadeCurricular investigacaoOperacionalLIG = new UnidadeCurricular("Investigação Operacional", "IO", "Investigação Operacional LIG",6, 2, 1, cursoLIG, anoLetivo, "A196FF");
                UnidadeCurricular linguagensProgramacaoIILIG = new UnidadeCurricular("Linguagens de Programação II", "LP2", "Linguagens de Programação II LIG",6, 2, 1, cursoLIG, anoLetivo, "92BEFF");
                UnidadeCurricular sistemasOperativosLIG = new UnidadeCurricular("Sistemas Operativos", "SO", "Sistemas Operativos LIG",6, 2, 1, cursoLIG, anoLetivo, "97FFEE");

                //2º ano - 2º semestre
                UnidadeCurricular engenhariaRequisitosTestesLIG = new UnidadeCurricular("Engenharia de Requisitos e Testes", "ERT", "Engenharia de Requisitos e Testes LIG",6, 2, 2, cursoLIG, anoLetivo, "A3FFB0");
                UnidadeCurricular gestaoFinanceiraLIG = new UnidadeCurricular("Gestão Financeira", "GF", "Gestão Financeira LIG",6, 2, 2, cursoLIG, anoLetivo, "E7FFA2");
                UnidadeCurricular programacaoWebLIG = new UnidadeCurricular("Programação Web", "PW", "Programação Web LIG",6, 2, 2, cursoLIG, anoLetivo, "FEEAAB");
                UnidadeCurricular redesComputadoresLIG = new UnidadeCurricular("Redes de Computadores", "RC", "Redes de Computadores LIG",6, 2, 2, cursoLIG, anoLetivo, "FF9E60");
                UnidadeCurricular sistemasSuporteDecisaoLIG = new UnidadeCurricular("Sistemas de Suporte à Decisão", "SSD", "Sistemas de Suporte à Decisão LIG",6, 2, 2, cursoLIG, anoLetivo, "FF8C96");

                //3º ano - 1º semestre
                UnidadeCurricular dataMiningLIG = new UnidadeCurricular("Data Mining", "DM", "Data Mining LIG",5, 3, 1, cursoLIG, anoLetivo, "EE97FF");
                UnidadeCurricular engenhariaSoftwareLIG = new UnidadeCurricular("Engenharia de Software", "ES", "Engenharia de Software LIG",5, 3, 1, cursoLIG, anoLetivo, "9795FF");
                UnidadeCurricular interacaoHumanoMaquinaLIG = new UnidadeCurricular("Interação Humano-Máquina", "IHM", "Interação Humano-Máquina LIG",5, 3, 1, cursoLIG, anoLetivo, "83B3FF");
                UnidadeCurricular sistemasMoveisEmpresariaisLIG = new UnidadeCurricular("Sistemas Móveis Empresariais", "SME", "Sistemas Móveis Empresariais LIG",5, 3, 1, cursoLIG, anoLetivo, "A1FFFE");

                //3º ano - 2º semestre
                UnidadeCurricular auditoriaSistemasInformacaoLIG = new UnidadeCurricular("Auditoria de Sistemas de Informação", "ASI", "Auditoria de Sistemas de Informação LIG",4, 3, 2, cursoLIG, anoLetivo, "95FFBC");
                UnidadeCurricular controloGestaoLIG = new UnidadeCurricular("Controlo de Gestão", "CG", "Controlo de Gestão LIG",3, 3, 2, cursoLIG, anoLetivo, "BEFFA1");
                UnidadeCurricular inteligenciaArtificialLIG = new UnidadeCurricular("Inteligência Artificial", "IA", "Inteligência Artificial LIG",5, 3, 2, cursoLIG, anoLetivo, "FFFFAD");
                UnidadeCurricular motivacaoLiderancaLIG = new UnidadeCurricular("Motivação e Liderança", "ML", "Motivação e Liderança LIG",3, 3, 2, cursoLIG, anoLetivo, "FFD87C");
                UnidadeCurricular sistemasInformacaoNuvemLIG = new UnidadeCurricular("Sistemas de Informação na Nuvem", "SIN", "Sistemas de Informação na Nuvem LIG",5, 3, 2, cursoLIG, anoLetivo, "FFAD6F");

                //3º ano - Anual
                UnidadeCurricular trabalhoFinalCursoLIG = new UnidadeCurricular("Trabalho Final de Curso", "TFC", "Trabalho Final de Curso",20, 3, 3, cursoLIG, anoLetivo, "FF8B7C");



                //LEIRT
                //1º ano - 1º semestre
                UnidadeCurricular fundamentosFisicaLEIRT = new UnidadeCurricular("Fundamentos de Física", "FF", "Fundamentos de Física LEIRT",6, 1, 1, cursoLEIRT, anoLetivo, "FF93F8");
                UnidadeCurricular fundamentosProgramacaoLEIRT = new UnidadeCurricular("Fundamentos de Programação", "FP", "Fundamentos de Programação LEIRT",6, 1, 1, cursoLEIRT, anoLetivo, "A199FF");
                UnidadeCurricular matematicaDiscretaLEIRT = new UnidadeCurricular("Matemática Discreta", "MATD", "Matemática Discreta LEIRT",6, 1, 1, cursoLEIRT, anoLetivo, "8CB4FF");
                UnidadeCurricular matematicaILEIRT = new UnidadeCurricular("Matemática I", "MATI", "Matemática I LEIRT",6, 1, 1, cursoLEIRT, anoLetivo, "82F6FF");
                UnidadeCurricular sistemasDigitaisLEIRT = new UnidadeCurricular("Sistemas Digitais", "SD", "Sistemas Digitais LEIRT",6, 1, 1, cursoLEIRT, anoLetivo, "8BFFCB");

                //1º ano - 2º semestre
                UnidadeCurricular algebraLinearLEIRT = new UnidadeCurricular("Álgebra Linear", "AL", "Álgebra Linear LEIRT",5, 1, 2, cursoLEIRT, anoLetivo, "B9FF9B");
                UnidadeCurricular algoritmiaEstruturasDadosLEIRT = new UnidadeCurricular("Algoritmia e Estruturas de Dados", "AED", "Algoritmia e Estruturas de Dados LEIRT",6, 1, 2, cursoLEIRT, anoLetivo, "FAFF9D");
                UnidadeCurricular arquiteturaComputadoresLEIRT = new UnidadeCurricular("Arquitetura de Computadores", "AC", "Arquitetura de Computadores LEIRT",5, 1, 2, cursoLEIRT, anoLetivo, "FFD675");
                UnidadeCurricular fundamentosEletronicaLEIRT = new UnidadeCurricular("Fundamentos de Eletrónica", "FE", "Fundamentos de Eletrónica LEIRT",4, 1, 2, cursoLEIRT, anoLetivo, "FFA782");
                UnidadeCurricular linguagensProgramacaoILEIRT = new UnidadeCurricular("Linguagens de Programação I", "LPI", "Linguagens de Programação I LEIRT",5, 1, 2, cursoLEIRT, anoLetivo, "FF8695");
                UnidadeCurricular matematicaIILEIRT = new UnidadeCurricular("Matemática II", "MATII", "Matemática II LEIRT",5, 1, 2, cursoLEIRT, anoLetivo, "F4B2FF");

                //2º ano - 1º semestre
                UnidadeCurricular basesDadosLEIRT = new UnidadeCurricular("Bases de Dados", "BD", "Bases de Dados LEIRT",6, 2, 1, cursoLEIRT, anoLetivo, "C3D3FF");
                UnidadeCurricular fundamentosTelecomunicacoesLEIRT = new UnidadeCurricular("Fundamentos de Telecomunicações", "FT", "Fundamentos de Telecomunicações LEIRT",6, 2, 1, cursoLEIRT, anoLetivo, "A8FFF4");
                UnidadeCurricular linguagensProgramacaoIILEIRT = new UnidadeCurricular("Linguagens de Programação II", "LPII", "Linguagens de Programação II LEIRT",6, 2, 1, cursoLEIRT, anoLetivo, "C3FFD5");
                UnidadeCurricular sinaisSistemasLEIRT = new UnidadeCurricular("Sinais e Sistemas", "SS", "Sinais e Sistemas LEIRT",6, 2, 1, cursoLEIRT, anoLetivo, "FFFBBB");
                UnidadeCurricular sistemasOperativosLEIRT = new UnidadeCurricular("Sistemas Operativos", "SO", "Sistemas Operativos LEIRT",6, 2, 1, cursoLEIRT, anoLetivo, "FFD4B1");

                //2º ano - 2º semestre
                UnidadeCurricular computacaoMovelLEIRT = new UnidadeCurricular("Computação Móvel", "CM", "Computação Móvel LEIRT",6, 2, 2, cursoLEIRT, anoLetivo, "FFBABB");
                UnidadeCurricular fundamentosPropagacaoRadiacaoLEIRT = new UnidadeCurricular("Fundamentos de Propagação e Radiação", "FPR", "Fundamentos de Propagação e Radiação LEIRT",6, 2, 2, cursoLEIRT, anoLetivo, "F9C6FE");
                UnidadeCurricular probabilidadeEstatisticaLEIRT = new UnidadeCurricular("Probabilidade e Estatística", "PE", "Probabilidade e Estatística LEIRT",6, 2, 2, cursoLEIRT, anoLetivo, "D1E8FF");
                UnidadeCurricular redesComputadoresLEIRT = new UnidadeCurricular("Redes de Computadores", "RC", "Redes de Computadores LEIRT",6, 2, 2, cursoLEIRT, anoLetivo, "C9FFFC");
                UnidadeCurricular sistemasTelecomunicacoesLEIRT = new UnidadeCurricular("Sistemas de Telecomunicações", "ST", "Sistemas de Telecomunicações LEIRT",6, 2, 2, cursoLEIRT, anoLetivo, "C9FFFC");

                //3º ano - 1º semestre
                UnidadeCurricular complementosRedeLEIRT = new UnidadeCurricular("Complementos de Rede", "CR", "Complementos de Rede LEIRT",9, 1, 1, cursoLEIRT, anoLetivo, "B9FFD3");
                UnidadeCurricular computacaoDistribuidaLEIRT = new UnidadeCurricular("Computação Distribuída", "CD", "Computação Distribuída LEIRT",5, 1, 1, cursoLEIRT, anoLetivo, "E6FFC1");
                UnidadeCurricular dataScienceLEIRT = new UnidadeCurricular("Data Science", "DS", "Data Science LEIRT",5, 1, 1, cursoLEIRT, anoLetivo, "FFF499");
                UnidadeCurricular engenhariaSoftwareLEIRT = new UnidadeCurricular("Engenharia de Software", "ES", "Engenharia de Software LEIRT",5, 1, 1, cursoLEIRT, anoLetivo, "FFCF85");
                UnidadeCurricular projetoTelecomunicacoesLEIRT = new UnidadeCurricular("Projeto de Telecomunicações", "PT", "Projeto de Telecomunicações LEIRT",5, 1, 1, cursoLEIRT, anoLetivo, "FF9770");

                //3º ano - 2º semestre
                UnidadeCurricular computacaoNuvemLEIRT = new UnidadeCurricular("Computação na Nuvem", "CN", "Computação na Nuvem LEIRT",6, 3, 2, cursoLEIRT, anoLetivo, "FF9380");
                UnidadeCurricular comunicacoesViaRadioLEIRT = new UnidadeCurricular("Comunicações Via Rádio", "CVR", "Comunicações Via Rádio LEIRT",6, 3, 2, cursoLEIRT, anoLetivo, "FFADDE");
                UnidadeCurricular projetoRedesInformaticasLEIRT = new UnidadeCurricular("Projeto de Redes Informáticas", "PRI", "Projeto de Redes Informáticas LEIRT",7, 3, 2, cursoLEIRT, anoLetivo, "D1BAFF");
                UnidadeCurricular redesComunicacoesSemFiosLEIRT = new UnidadeCurricular("Redes de Comunicações sem Fios", "RCF", "Redes de Comunicações sem Fios LEIRT",6, 3, 2, cursoLEIRT, anoLetivo, "E9B4FE");
                UnidadeCurricular segurancaInformaticaLEIRT = new UnidadeCurricular("Segurança Informática", "SI", "Segurança Informática LEIRT",5, 3, 2, cursoLEIRT, anoLetivo, "92B4FF");

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
