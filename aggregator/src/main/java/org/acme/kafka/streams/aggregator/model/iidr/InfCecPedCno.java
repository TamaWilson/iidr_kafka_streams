package org.acme.kafka.streams.aggregator.model.iidr;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfCecPedCno {

    @JsonProperty("AUD_ENTTYP")
    public String audEnttyp;
    @JsonProperty("AUD_APPLY_TIMESTAMP")
    public String audApplyTimestamp;
    @JsonProperty("CD_IPCNO")
    public String cdIpcno;
    @JsonProperty("CD_IPCNO_SEQ")
    public String cdIpcnoSeq;
    @JsonProperty("CD_ICPCNO")
    public String cdIcpno;
    @JsonProperty("CD_ICPCNO_ORI")
    public String cdIcpnoOri;
    @JsonProperty("CD_ICPCNO_CPJ_FAT")
    public String cdIcpnoCpjFat;
    @JsonProperty("CD_ICPCNO_PZO_EXD")
    public String cdIcpnoPzoExd;
    @JsonProperty("CD_ICPCNO_PZO_ETQ")
    public Object cdIcpnoPzoEtq;
    @JsonProperty("CD_ICPCNO_PZO_CLI")
    public String cdIcpnoPzoCli;
    @JsonProperty("CD_ICPCNO_TIP_ETQ")
    public String cdIcpnoTipEtq;
    @JsonProperty("CD_ICPCNO_CPJ_RDP")
    public String cdIcpnoCpjRdp;
    @JsonProperty("CD_ICPCNO_ORD_DVL")
    public Object cdIcpnoOrdDvl;
    @JsonProperty("CD_ICPCNO_TRP")
    public Object cdIcpnoTrp;
    @JsonProperty("CD_ICPCNO_CTT_TRP")
    public Object cdIcpnoCttTrp;
    @JsonProperty("CD_ICPCNO_IDE_LOJ")
    public String cdIcpnoIdeLoj;
    @JsonProperty("CD_ICPCNO_TIP_DVN")
    public String cdIcpnoTipDvn;
    @JsonProperty("CD_ICPCNO_DVN")
    public String cdIcpnoDvn;
    @JsonProperty("CD_ICPCNO_DVN_SEQ")
    public String cdIcpnoDvnSeq;
    @JsonProperty("CD_ICPCNO_REF_ETG")
    public Object cdIcpnoRefEtg;
    @JsonProperty("TS_ICPCNO_ICL")
    public String cdIcpnoIcl;
    @JsonProperty("CD_ICPCNO_SEQ_REF")
    public Object cdIcpnoSeqRef;
    @JsonProperty("OBJETO")
    public String objeto;
    @JsonProperty("ENTTYP")
    public String enttyp;

}
