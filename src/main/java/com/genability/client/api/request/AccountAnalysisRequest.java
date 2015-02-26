package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;

import com.genability.client.types.PropertyData;
import com.genability.client.types.TariffRate;

public class AccountAnalysisRequest extends AbstractRequest implements Serializable {

        private static final long serialVersionUID = 1L;

        private String providerAccountId;
        private String accountId;

        private DateTime fromDateTime;
        private DateTime toDateTime;

        private List<PropertyData> propertyInputs;

        private List<TariffRate> rateInputs;

        public String getProviderAccountId() {
                return providerAccountId;
        }

        public void setProviderAccountId(String providerAccountId) {
                this.providerAccountId = providerAccountId;
        }

        public String getAccountId() {
                return accountId;
        }

        public void setAccountId(String accountId) {
                this.accountId = accountId;
        }

        public DateTime getFromDateTime() {
                return fromDateTime;
        }

        public void setFromDateTime(DateTime fromDateTime) {
                this.fromDateTime = fromDateTime;
        }

        public DateTime getToDateTime() {
                return toDateTime;
        }

        public void setToDateTime(DateTime toDateTime) {
                this.toDateTime = toDateTime;
        }

        public List<TariffRate> getRateInputs() {
                return rateInputs;
        }

        public void setRateInputs(List<TariffRate> rateInputs) {
                this.rateInputs = rateInputs;
        }

        public List<PropertyData> getPropertyInputs() {
                return propertyInputs;
        }

        public void setPropertyInputs(List<PropertyData> propertyInputs) {
                this.propertyInputs = propertyInputs;
        }
}
