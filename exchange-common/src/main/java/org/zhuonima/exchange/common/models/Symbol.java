package org.zhuonima.exchange.common.models;

public enum Symbol {

    BTC_USDT(Currency.BTC, Currency.USDT),
    ETH_USDT(Currency.ETH, Currency.USDT),
    LTC_USDT(Currency.ETH, Currency.USDT),
    BCH_USDT(Currency.ETH, Currency.USDT);

    public final Currency base;
    public final Currency quote;

    private Symbol(Currency base, Currency quote) {
        this.base = base;
        this.quote = quote;
    }
}
