/**
 *  Copyright (C) 2009-2013 Typesafe Inc. <http://www.typesafe.com>
 */
package distributed.rete.bootable;

import akka.actor.ActorSystem;
import akka.kernel.Bootable;

import com.typesafe.config.ConfigFactory;

public class RemoteBootable implements Bootable {
	private ActorSystem system;

	public RemoteBootable() {
//		System.out.println("==============================================================================\n" +
//				"\n" +
//				"                                                   ZZ:\n" +
//				"                                                  ZZZZ\n" +
//				"                                                 ZZZZZZ\n" +
//				"                                                ZZZ' ZZZ\n" +
//				"                                       ~7      7ZZ'   ZZZ\n" +
//				"                                      :ZZZ:   IZZ'     ZZZ\n" +
//				"                                     ,OZZZZ.~ZZ?        ZZZ\n" +
//				"                                    ZZZZ' 'ZZZ$          ZZZ\n" +
//				"                           .       $ZZZ   ~ZZ$            ZZZ\n" +
//				"                         .=Z?.   .ZZZO   ~ZZ7              OZZ\n" +
//				"                        .ZZZZ7..:ZZZ~   7ZZZ                ZZZ~\n" +
//				"                      .$ZZZ$Z+.ZZZZ    ZZZ:                  ZZZ$\n" +
//				"                   .,ZZZZ?'  =ZZO=   .OZZ                     'ZZZ\n" +
//				"                 .$ZZZZ+   .ZZZZ    IZZZ                        ZZZ$\n" +
//				"               .ZZZZZ'   .ZZZZ'   .ZZZ$                          ?ZZZ\n" +
//				"            .ZZZZZZ'   .OZZZ?    ?ZZZ                             'ZZZ$\n" +
//				"        .?ZZZZZZ'    .ZZZZ?    .ZZZ?                                'ZZZO\n" +
//				"    .+ZZZZZZ?'    .7ZZZZ'    .ZZZZ                                    :ZZZZ\n" +
//				" .ZZZZZZ$'     .?ZZZZZ'   .~ZZZZ                                        'ZZZZ.\n" +
//				"\n" +
//				"\n" +
//				"        NNNNN         NNNNN              $NNNN+\n" +
//				"        NNNNN         NNNNN              $NNNN+\n" +
//				"        NNNNN         NNNNN              $NNNN+\n" +
//				"        NNNNN         NNNNN              \n" +
//				"                      NNNNN              \n" +
//				"    =NNNNNNNNND$      NNNNN     DDDDDD:  $NNNN+\n" +
//				"   NNNNNNNNNNNNND     NNNNN    DNNNNN    $NNNN+\n" +
//				"  NNNNN$    DNNNNN    NNNNN  $NNNNN~     $NNNN+\n" +
//				"   ?DN~      NNNNN    NNNNN MNNNNN       $NNNN+\n" +
//				"            DNNNNN    NNNNNDNNNN$        $NNNN+\n" +
//				"     ZNDNNNNNNNNND    NNNNNNNNNND,       $NNNN+\n" +
//				"   NNNNNNNDDINNNNN    NNNNNNNNNNND       $NNNN+\n" +
//				" :NNNND      NNNNN    NNNNNN  DNNNN,     $NNNN+\n" +
//				" DNNNN       NNNNN    NNNNN    DNNNN     $NNNN+\n" +
//				" DNNNNO     NNNNNN    NNNNN     NNNNN    $NNNN+\n" +
//				"  NNNNNNDDNNNNNNNN    NNNNN     =NNNNN   $NNNN+\n" +
//				"   NNNNNNNNN  NNNN$   NNNNN      8NNNND  $NNNN+\n" +
//				"\n" +
//				"==============================================================================\n" +
//				"");

		system = ActorSystem.create("ReteNet", ConfigFactory.load().getConfig("ReteNet"));
		System.out.println("ReteNet actorsystem initialized.");
	}

	public void startup() {
	}

	public void shutdown() {
		system.shutdown();
	}
}
