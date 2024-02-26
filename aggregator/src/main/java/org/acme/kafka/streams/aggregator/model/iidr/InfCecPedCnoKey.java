package org.acme.kafka.streams.aggregator.model.iidr;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfCecPedCnoKey {


    @JsonProperty("AUD_ENTTYP")
    private String audEnttyp;
    @JsonProperty("AUD_APPLY_TIMESTAMP")
    private String audApplyTimestamp;
    @JsonProperty("CD_IPCNO")
    private String cdIpcno;
    @JsonProperty("CD_IPCNO_SEQ")
    private String cdIpcnoSeq;
    @JsonProperty("CD_ICPCNO")
    private String cdIcpcno;
    @JsonProperty("CD_ICPCNO_ORI")
    private String cdIcpcnoOri;
    @JsonProperty("CD_ICPCNO_CPJ_FAT")
    private String cdIcpcnoCpjFat;
    @JsonProperty("CD_ICPCNO_PZO_EXD")
    private String cdIcpcnoPzoExd;
    @JsonProperty("CD_ICPCNO_PZO_ETQ")
    private Object cdIcpcnoPzoEtq;
    @JsonProperty("CD_ICPCNO_PZO_CLI")
    private String cdIcpcnoPzoCli;
    @JsonProperty("CD_ICPCNO_TIP_ETQ")
    private String cdIcpcnoTipEtq;
    @JsonProperty("CD_ICPCNO_CPJ_RDP")
    private String cdIcpcnoCpjRdp;
    @JsonProperty("CD_ICPCNO_ORD_DVL")
    private Object cdIcpcnoOrdDvl;
    @JsonProperty("CD_ICPCNO_TRP")
    private String cdIcpcnoTrp;
    @JsonProperty("CD_ICPCNO_CTT_TRP")
    private String cdIcpcnoCttTrp;
    @JsonProperty("CD_ICPCNO_IDE_LOJ")
    private String cdIcpcnoIdeLoj;
    @JsonProperty("CD_ICPCNO_TIP_DVN")
    private String cdIcpcnoTipDvn;
    @JsonProperty("CD_ICPCNO_DVN")
    private String cdIcpcnoDvn;
    @JsonProperty("CD_ICPCNO_DVN_SEQ")
    private String cdIcpcnoDvnSeq;
    @JsonProperty("CD_ICPCNO_REF_ETG")
    private Object cdIcpcnoRefEtg;
    @JsonProperty("TS_ICPCNO_ICL")
    private String tsIcpcnoIcl;
    @JsonProperty("CD_ICPCNO_SEQ_REF")
    private Object cdIcpcnoSeqRef;
    @JsonProperty("OBJETO")
    private String objeto;
    @JsonProperty("ENTTYP")
    private String enttyp;

}
