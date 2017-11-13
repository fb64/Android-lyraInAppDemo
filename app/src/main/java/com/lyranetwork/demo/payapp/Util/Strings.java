/*
 * *****************************************************************************
 *  Copyright (c) 2016 Lyra Network. All rights reserved.                      *
 *                                                                             *
 *  Licensed under the Lyra Network Payzen mobile SDK License.                 *
 *  You may not use this file except in compliance with the License.           *
 *  You may obtain a copy of the License at                                    *
 *                                                                             *
 *       http://media.lyra-network.com/mpos/android/sdk/LICENSE                *
 *                                                                             *
 *  *****************************************************************************
 */

package com.lyranetwork.demo.payapp.Util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * String tools
 */
public class Strings {

    /**
     * retourne a partir d'un entier en centime le prix en euro
     *
     * @param priceInCent
     * @param uniteFractionnaire nombre de chiffre apres la virgule
     * @return
     */
    public static String priceToString(long priceInCent, String separator, int uniteFractionnaire) {
        DecimalFormat decimalFormat = new DecimalFormat();
        BigDecimal bigDecimalPriceInCent = BigDecimal.valueOf(priceInCent);
        if (uniteFractionnaire == 0) {
            decimalFormat.applyPattern("#,###,###,##0");
            return decimalFormat.format(bigDecimalPriceInCent);
        } else if (uniteFractionnaire == 1) {
            decimalFormat.applyPattern("#,###,###,##0.0");
            return decimalFormat.format(bigDecimalPriceInCent.multiply(BigDecimal.valueOf(0.1)))
                                .replace(",", separator);
        } else if (uniteFractionnaire == 2) {
            decimalFormat.applyPattern("#,###,###,##0.00");
            return decimalFormat.format(bigDecimalPriceInCent.multiply(BigDecimal.valueOf(0.01)))
                                .replace(",", separator);
        } else {
            //Pas traite on met 2 plus un report d'erreur
            decimalFormat.applyPattern("#,###,###,##0.00");
            return decimalFormat.format(bigDecimalPriceInCent.multiply(BigDecimal.valueOf(0.01)))
                                .replace(",", separator);
        }
    }
}
