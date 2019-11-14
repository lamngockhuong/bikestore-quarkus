package com.ngockhuong.config

import io.quarkus.runtime.ShutdownEvent
import io.quarkus.runtime.StartupEvent
import io.quarkus.runtime.configuration.ProfileManager
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.slf4j.LoggerFactory
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes

@ApplicationScoped
class ApplicationLifecycle {
    companion object {
        private val LOG = LoggerFactory.getLogger(ApplicationLifecycle::class.java)
    }

    @ConfigProperty(name = "server.timezone")
    lateinit var timeZone: String

    fun onStart(@Observes ev: StartupEvent) {
        LOG.info("The application is starting with ${ProfileManager.getActiveProfile()} profile")
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }

    fun onStop(@Observes ev: ShutdownEvent) {
        LOG.info("The application is stopping...")
    }
}
