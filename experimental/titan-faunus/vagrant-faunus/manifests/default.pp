class must-have {
  include apt
  apt::ppa { "ppa:webupd8team/java": }

  exec { 'apt-get update':
    command => '/usr/bin/apt-get update',
    before => Apt::Ppa["ppa:webupd8team/java"],
  }

  exec { 'apt-get update 2':
    command => '/usr/bin/apt-get update',
    require => Apt::Ppa["ppa:webupd8team/java"],
  }

  package { ["mc", "curl"]:
    ensure => present,
    require => Exec["apt-get update"],
    before => Apt::Ppa["ppa:webupd8team/java"],
  }

  package { ["oracle-java7-installer"]:
    ensure => present,
    require => Exec["apt-get update 2"],
  }

  exec {
    "Oracle Java 7":
    command => "echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections && echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections",
    cwd => "/home/vagrant",
    user => "vagrant",
    path => "/usr/bin/:/bin/",
    require => Package["curl"],
    before => Package["oracle-java7-installer"],
    logoutput => true,
  }

  package { ["unzip"]:
    ensure => present,
  }

  exec { "Install graph tools":
    command => "/vagrant/bootstrap.sh",
    user => "vagrant",
    require => Package["unzip"],
  }

  exec { "Start Hadoop":
    command => "/vagrant/start-hadoop.sh",
    user => "vagrant",
    require => [ Exec["Install graph tools"], Package["oracle-java7-installer"] ]
  }

}

include must-have
