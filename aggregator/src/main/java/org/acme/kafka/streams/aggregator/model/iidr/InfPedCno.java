package org.acme.kafka.streams.aggregator.model.iidr;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfPedCno {

    @JsonProperty("AUD_ENTTYP")
    private String audEnttyp;
    @JsonProperty("AUD_APPLY_TIMESTAMP")
    private String audApplyTimestamp;
    @JsonProperty("CD_IPCNO")
    private String cdIpcno;
    @JsonProperty("CD_IPCNO_SEQ")
    private String cdIpcnoSeq;
    @JsonProperty("CD_IPCNO_ERP")
    private String cdIpcnoErp;
    @JsonProperty("CD_IPCNO_CIA")
    private String cdIpcnoCia;
    @JsonProperty("CD_IPCNO_TIP_PED")
    private String cdIpcnoTipPed;
    @JsonProperty("CD_IPCNO_CNA_VND")
    private String cdIpcnoCnaVnd;
    @JsonProperty("CD_IPCNO_LIS_CPR")
    private Object cdIpcnoLisCpr;
    @JsonProperty("DS_IPCNO_EML")
    private String dsIpcnoEml;
    @JsonProperty("TS_IPCNO_ICL_PED_CNO")
    private String tsIpcnoIclPedCno;
    @JsonProperty("DT_IPCNO_CRI")
    private Object dtIpcnoCri;
    @JsonProperty("ST_IPCNO_IST_IES")
    private Object stIpcnoIstIes;
    @JsonProperty("ST_IPCNO_OPA_SPE")
    private Object stIpcnoOpaSpe;
    @JsonProperty("DS_IPCNO_IPA_CLI")
    private String dsIpcnoIpaCli;
    @JsonProperty("ST_CLI_SXO")
    private String stCliSxo;
    @JsonProperty("CD_IPCNO_UTM_B2B")
    private Object cdIpcnoUtmB2b;
    @JsonProperty("CD_IPCNO_UTM_PAR_B2B")
    private Object cdIpcnoUtmParB2b;
    @JsonProperty("CD_IPCNO_UTM_CPN_B2B")
    private Object cdIpcnoUtmCpnB2b;
    @JsonProperty("CD_IPCNO_CTT_B2B")
    private Object cdIpcnoCttB2b;
    @JsonProperty("CD_IPCNO_CPN_B2B")
    private Object cdIpcnoCpnB2b;
    @JsonProperty("CD_IPCNO_PED_EXT_B2B")
    private String cdIpcnoPedExtB2b;
    @JsonProperty("ST_IPCNO_IPT_CLI_FNE")
    private String stIpcnoIptCliFne;
    @JsonProperty("CD_IPCNO_UND_NEG")
    private String cdIpcnoUndNeg;
    @JsonProperty("CD_IPCNO_ATV_FIM")
    private String cdIpcnoAtvFim;
    @JsonProperty("CD_IPCNO_EMP_FUN")
    private Object cdIpcnoEmpFun;
    @JsonProperty("CD_IPCNO_FUN")
    private Object cdIpcnoFun;
    @JsonProperty("CD_IPCNO_FIL_FUN")
    private Object cdIpcnoFilFun;
    @JsonProperty("OBJETO")
    private String objeto;
    @JsonProperty("ENTTYP")
    private String enttyp;

}
