package uk.ac.ebi.ddi.annotation.service;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.ddi.annotation.model.DatasetTobeEnriched;
import uk.ac.ebi.ddi.annotation.model.EnrichedDataset;

import java.io.IOException;
import java.util.ArrayList;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationTestContext.xml"})

public class DDIAnnotationServiceTest {
    @Autowired
    DDIAnnotationService annotService = new DDIAnnotationService();

    @Test
    public void annotationTest() throws IOException, JSONException {

        long startTime = System.currentTimeMillis();
        for (int i=0; i<10; i++) {
    //        System.out.println("those words are in ontologies: " + annotService.getWordsInFiled("Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye.Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye."));
            for (int j = 0; j < 20; j++) {
//                System.out.println("the synonms is: " + annotService.getSynonymsForWord("cancer"));
                ArrayList<String> temp = annotService.getSynonymsForWord("cancer");
                for (String temp2 : temp) {
                    System.out.println(temp2);
                }
                System.out.println("--------------------------------");
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds to annotate 100 field from Bioontology web service");

    }

    @Test
    public void enrichmentTest() throws IOException, JSONException {

        DatasetTobeEnriched datasetTobeEnriched1 = new DatasetTobeEnriched("PXD002287", "PRIDE");
        datasetTobeEnriched1.setTitle("Proteome-wide analysis of lysine acetylation suggests its broad regulatory scope in Saccharomyces cerevisiae.");

        String abstraction = "Post-translational modification of proteins by lysine acetylation plays important regulatory roles in living cells. The budding yeast Saccharomyces cerevisiae is a widely used unicellular eukaryotic model organism in biomedical research. S. cerevisiae contains several evolutionary conserved lysine acetyltransferases and deacetylases. However, only a few dozen acetylation sites in S. cerevisiae are known, presenting a major obstacle for further understanding the regulatory roles of acetylation in this organism. Here we use high resolution mass spectrometry to identify about 4000 lysine acetylation sites in S. cerevisiae. Acetylated proteins are implicated in the regulation of diverse cytoplasmic and nuclear processes including chromatin organization, mitochondrial metabolism, and protein synthesis. Bioinformatic analysis of yeast acetylation sites shows that acetylated lysines are significantly more conserved compared with nonacetylated lysines. A large fraction of the conserved acetylation sites are present on proteins involved in cellular metabolism, protein synthesis, and protein folding. Furthermore, quantification of the Rpd3-regulated acetylation sites identified several previously known, as well as new putative substrates of this deacetylase. Rpd3 deficiency increased acetylation of the SAGA (Spt-Ada-Gcn5-Acetyltransferase) complex subunit Sgf73 on K33. This acetylation site is located within a critical regulatory domain in Sgf73 that interacts with Ubp8 and is involved in the activation of the Ubp8-containing histone H2B deubiquitylase complex. Our data provides the first global survey of acetylation in budding yeast, and suggests a wide-ranging regulatory scope of this modification. The provided dataset may serve as an important resource for the functional analysis of lysine acetylation in eukaryotes.";
        datasetTobeEnriched1.setAbstractDescription(abstraction);

        String sampleProtocol = "Raw MS data files obtained from the LTQ Orbitrap Velos or Q-Exactive were processed using MaxQuant (development version 1.2.7.1, http://www.maxquant.org/) (38, 39). Peptide ion masses and fragment spectra were searched against the Saccharomyces Genome Database (SGD) (40) release 63 containing 6717 putative protein sequences (http://downloads.yeastgenome.org/). Peptide sequences were searched using trypsin specificity and allowing a maximum of two missed cleavages. Carbamidomethylation of cystein";
        datasetTobeEnriched1.setSampleProtocol(sampleProtocol);

        String dataProtocol = "S. cerevisiae cells from a lysine auxotroph strain (BY4742) were grown in a synthetic complete medium containing “light” lysine (l-lysine 12C6,14N2, or Lysine0) or “heavy” lysine (l-lysine 13C6,15N2, or Lysine8) for more than 10 generations to an absorbance (measured at 600 nm (OD600)) value of ∼0.7. Cells were harvested by centrifugation at 3000 × g for 5 min, washed once in water, and resuspended in lysis buffer (150 mm KAc, 2 mm MgAc, 20 mm Hepes, pH 7.4) supplemented with Protease Inhibitor Mixture (Roche). The cell-suspension was instantly frozen in liquid nitrogen and cells were cryo-grinded using a MM400 ball mill (Retsch) for 2 × 3 min at 25 Hz. Frozen powdered lysates were transferred to 50 ml tubes, thawed, and Triton-X was added to a final concentration of 1%, followed by incubation at 4 °C for 30 min. Extracts were centrifuged twice at 3500 × g for 10 min to remove cellular debris. Protein concentrations were measured using BCA protein assay kit (Thermo Scientific) and lysates were stored at −80 °C until further use. Cell lysates were thawed and 20 mg of proteins from “light” and “heavy” labeled samples were mixed. Proteins were precipitated with 4 volumes of ice-cold acetone. After incubation at −20 °C for more than 1 h, the precipitate was pelleted at 3000 × g for 10 min and the liquid phase was discarded. The protein pellet was dissolved in 8 m urea solution (6 m urea, 2 m thiourea, 10 mm HEPES pH 8.0) and the protein concentration was measured using Bradford assay. Protein samples were treated with 1 mm DTT for 45 min and subsequently alkylated with 5.5 mm iodoacetamide for 45 min in the dark. Proteins were digested with endoproteinase Lys-C (1 μg Lys-C per 100 μg protein) for 12–16 h at 25 °C. Samples were subsequently diluted with H2O to reduce the urea concentration to 2 m and the pH was adjusted to 8.0 with 1 m ammonium bicarbonate solution. Trypsin endoproteinase was added (1 μg Trypsin per 100 μg protein) and the samples were further digested for 12–16 h at 25 °C. Trypsin activity was stopped by addition of trifluoroacetic acid (TFA) to a final concentration of 1% and the peptide solution was incubated at 4 °C for 1–2 h. The solution was clarified by centrifugation at 3000 × g and peptides were purified using a C18 Sep-Pak cartridges (Waters, Milford, MA). Peptides were eluted from the C18 cartridges with 5 × 2 ml of 40% acetonitrile, 0.1% TFA in H2O. To remove acetonitrile, the sample was freeze-dried. Peptides were redissolved in immune affinity purification buffer (50 mm 3-(N-morpholino)propanesulfonic acid pH 7.2, 10 mm Na3PO4, 50 mm NaCl) and the peptide solution was clarified by centrifugation at 13000 × g for 5 min. Fifty microliters of agarose conjugated anti-acetyllysine antibodies (ImmuneChem Pharmaceuticals Inc., Burnaby, Canada, catalog number ICP0388) were added to the peptide mix (∼20 mg) and incubated on a rotating wheel at 4 °C for 12–16 h. The antibody batch numbers 022808 and 091211 were used for obtaining data set 1 (supplemental Table S1), and dataset 2 (supplemental Table S2), respectively. The immunoprecipitates were washed 3 times with ∼20 volumes ice-cold immunoaffinity purification (IAP) buffer and subsequently three times with ∼20 volumes ice-cold H2O. Peptides were eluted with 0.15% TFA in water. The eluted peptides were separated into 12 fractions by isoelectric focusing as described (30, 31), or fractioned into four fractions by micro-column-based strong cation exchange fractionation (32). The fractionated peptides were purified on StageTips packed with C18 reversed-phase material (32).Peptide fractions from immunoprecipitated samples were analyzed on a hybrid linear ion-trap Orbitrap (LTQ-Orbitrap Velos, Thermo Scientific) or quadrupole Orbitrap (Q-Exactive, Thermo Scientific) mass spectrometer equipped with a nanoflow HPLC system (Thermo Scientific) as described. Peptide samples were loaded onto C18 reversed phase columns (15 cm length, 75 μm inner diameter) and peptides were eluted with a linear gradient (3–4 h) from 8 to 40% acetonitrile containing 0.5% acetic acid. The mass spectrometers were operated in data dependent mode, automatically switching between MS and MS2 acquisition. Survey full scan MS spectra (m/z 300–1700) were acquired in the Orbitrap. The 10 most intense ions were sequentially isolated and fragmented by higher-energy C-trap dissociation (HCD). An ion selection threshold of 5000 counts was used. Peptides with unassigned charge states, as well as with charge states less than +2 were excluded from fragmentation. Fragment spectra were recorded in the Orbitrap mass analyzer. A lock mass ion from ambient air (m/z 445.120025) was used for internal calibration of measurements in the Orbitrap on LTQ-Orbitrap Velos mass spectrometers.";
        datasetTobeEnriched1.setDataProtocol(dataProtocol.substring(0,dataProtocol.length()));

        EnrichedDataset enrichedDataset1 = annotService.enrichment(datasetTobeEnriched1);
        System.out.println(enrichedDataset1.getEnrichedTitle());
        System.out.println(enrichedDataset1.getEnrichedAbstractDescription());
        System.out.println(enrichedDataset1.getEnrichedSampleProtocol());
        System.out.println(enrichedDataset1.getEnrichedDataProtocol());

    }
}