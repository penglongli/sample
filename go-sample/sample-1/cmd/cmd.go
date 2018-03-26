package cmd

import (
	log "github.com/sirupsen/logrus"
	"github.com/spf13/cobra"
	"github.com/spf13/viper"
	"go-sample/sample-1/server"
	"os"
)

var cfgFile string

var RootCmd = &cobra.Command{
	Use:   "Github-API",
	Short: "Github API usage sample",
	Run: func(cmd *cobra.Command, args []string) {
		server.NewSample1(&server.Sample1Config{
			Port:     viper.GetString("port"),
			UserName: viper.GetString("user_name"),
		}).Start()
	},
}

func Run() {
	if err := RootCmd.Execute(); err != nil {
		log.Error(err)
		os.Exit(-1)
	}
}

func init() {
	cobra.OnInitialize(initConfig)

	RootCmd.PersistentFlags().StringVarP(&cfgFile, "config", "c", "", "config file (default is $HOME/config.yml)")
}

func initConfig() {
	if cfgFile != "" {
		viper.SetConfigFile(cfgFile)
	}

	viper.SetConfigName("config")
	viper.AddConfigPath(".")
	viper.AddConfigPath("$HOME")

	viper.AutomaticEnv()

	err := viper.ReadInConfig()
	if err == nil {
		log.Info("Using config file: " + viper.ConfigFileUsed())
	}
}
